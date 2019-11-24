/*
 * Copyright (c) 2018-2019 Reposilite Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.panda_lang.reposilite.resource.maven;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.panda_lang.reposilite.resource.AbstractSubServiceController;
import org.panda_lang.reposilite.resource.Resource;
import org.panda_lang.reposilite.user.role.IsAdmin;
import org.panda_lang.reposilite.utils.FilesUtils;
import org.panda_lang.reposilite.utils.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@ApiOperation("Operations pertaining to the Maven repositories")
@RequestMapping("api/repository/maven")
@RestController
class MavenController extends AbstractSubServiceController<MavenService> {

    @Autowired
    MavenController(MavenService mavenService) {
        super(mavenService);
    }

    @ApiOperation("Prints available repositories")
    @GetMapping
    public ResponseEntity<Map<String, Object>> repositories() {
        return ResponseEntity.ok(new LinkedHashMap<String, Object>() {{
            getService().getNames().forEach(name -> this.put("name", name));
        }});
    }

    @ApiOperation("Returns groups located in the repository")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Repository not found"),
            @ApiResponse(code = 200, message = "Successfully returned")
    })
    @GetMapping("/{repository}")
    public ResponseEntity<Collection<String>> repository(@PathVariable @ApiParam("Repository name") String repository) {
        Optional<RepositoryResource> repositoryResource = getService().getRepository(repository);

        if (!repositoryResource.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(repositoryResource.get().getChildrenNames());
    }

    @ApiOperation("Returns chind nodes located in the requested entity")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Repository entity not found"),
            @ApiResponse(code = 200, message = "Successfully returned")
    })
    @GetMapping("/**")
    public ResponseEntity<Object> repository(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return super.getEntity(request, response);
    }

    @IsAdmin
    @ApiOperation("Adds artifact")
    @ApiResponses({
            @ApiResponse(code = 403, message = "File extensions not allowed"),
            @ApiResponse(code = 403, message = "Url doesn't match with Artifact's format"),
            @ApiResponse(code = 204, message = "Successfully updated")
    })
    @PutMapping("/{repository}/**")
    public ResponseEntity<Object> putArtifact(@PathVariable String repository, @RequestBody MultipartFile file, HttpServletRequest request) throws IOException {
        if (!SUPPORTED_EXTENSIONS.containsKey(FilenameUtils.getExtension(file.getOriginalFilename()))) {
            return ResponseEntity.badRequest().build();
        }

        Optional<RepositoryResource> repositoryResourceValue = getService().getRepository(repository);

        if (!repositoryResourceValue.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        String entityQualifier = RequestUtils.extractWildcard(request);
        RepositoryResource repositoryResource = repositoryResourceValue.get();
        MavenMetadata metadata = MavenMetadata.ofSystemPath(Paths.get("\\" + entityQualifier + File.separator + file.getOriginalFilename()).toString());
        Optional<Resource> entityValue = repositoryResource.find(entityQualifier);

        if (!entityValue.isPresent() && StringUtils.isBlank(metadata.getBuildVersion())) {
            return ResponseEntity.badRequest().build();
        }

        Path buildDirectory = Paths.get(repositoryResource.getFile().getPath() + File.separator + entityQualifier);
        Path buildFile = Paths.get(buildDirectory + File.separator + file.getOriginalFilename());

        if (!entityValue.isPresent()) {
            MetadataFileFactory metadataFileFactory = new MetadataFileFactory(getService());
            metadataFileFactory.createMetadataFile(repositoryResource, metadata, new MavenMetadataPaths(buildDirectory, buildFile), file);
            return ResponseEntity.noContent().build();
        }

        Resource entity = entityValue.get();

        if (!(entity instanceof BuildResource)) {
            return ResponseEntity.badRequest().build();
        }

        FilesUtils.storeFile(buildDirectory, file, false);
        FilesUtils.writeFileChecksums(buildFile.toAbsolutePath());
        GroupResource group = repositoryResource.getGroup(metadata.getGroupName());

        if (group == null) {
            return ResponseEntity.notFound().build();
        }

        getService().generateMetaDataFile(repositoryResource, group, group.getArtifact(metadata.getArtifactName()), buildDirectory.getParent());
        return ResponseEntity.noContent().build();
    }

}
