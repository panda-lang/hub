package org.panda_lang.reposilite.depository.maven;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.panda_lang.reposilite.depository.DepositoryEntity;
import org.panda_lang.reposilite.depository.DepositoryResponse;
import org.panda_lang.reposilite.user.security.IsAdmin;
import org.panda_lang.reposilite.utils.FilesUtils;
import org.panda_lang.reposilite.utils.RequestUtils;
import org.panda_lang.reposilite.utils.ResponseUtils;
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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@ApiOperation("Operations pertaining to repository")
@RequestMapping("api/repository/maven")
@RestController
class MavenDepositoryController {

    private final MavenDepositoryService mavenDepositoryService;

    @Autowired
    MavenDepositoryController(MavenDepositoryService mavenDepositoryService) {
        this.mavenDepositoryService = mavenDepositoryService;
    }

    @ApiOperation("Prints available repositories")
    @GetMapping
    public ResponseEntity<Map<String, Object>> repositories() {
        return ResponseEntity.ok(new LinkedHashMap<String, Object>() {{
            mavenDepositoryService.getNames().forEach(name -> this.put("name", name));
        }});
    }

    @ApiOperation("Returns name of repository")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Repository not found"),
            @ApiResponse(code = 200, message = "Successfully returned")
    })
    @GetMapping("/{repository}")
    public ResponseEntity<Map<String, Object>> repository(@PathVariable @ApiParam("Repository name") String repository) {
        if (this.mavenDepositoryService.getDepository(repository) == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(Collections.singletonMap("name", repository));
    }

    @ApiOperation("Returns repository entity")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Repository entity not found"),
            @ApiResponse(code = 200, message = "Successfully returned")
    })
    @GetMapping("/{repository}/**")
    public ResponseEntity<Object> repository(@PathVariable @ApiParam("Repository name") String repository, HttpServletRequest request, HttpServletResponse response) throws Exception {
        MavenDepository mavenDepository = this.mavenDepositoryService.getDepository(repository);

        if (mavenDepository == null) {
            return ResponseEntity.notFound().build();
        }

        String entityQualifier = RequestUtils.extractWildcard(request);
        Optional<DepositoryEntity> entityValue = mavenDepository.find(entityQualifier);

        if (!entityValue.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        DepositoryEntity entity = entityValue.get();

        // TODO: Resource handler
        if (entity instanceof Data) {
            return ResponseUtils.returnFile(response, "application/java", ((Data) entity).getFile());
        }

        File currentFile = new File(mavenDepository.getRootFile() + "/" + entityQualifier);
        return ResponseEntity.ok(new DepositoryResponse(currentFile.getPath(), currentFile.list()));
    }

    @IsAdmin
    @ApiOperation("Adds artifact")
    @ApiResponses({
            @ApiResponse(code = 403, message = "File extensions not allowed"),
            @ApiResponse(code = 403, message = "Url doesn't match with Artifact's format"),
            @ApiResponse(code = 204, message = "Successfully updated")
    })
    @PutMapping("/{repository}/**")
    public ResponseEntity<Object> addArtifact(@PathVariable String repository, @RequestBody MultipartFile file, HttpServletRequest request) throws IOException {
        if (!Arrays.asList("jar", "pom", "xml").contains(FilenameUtils.getExtension(file.getOriginalFilename()))) {
            return ResponseEntity.badRequest().build();
        }

        MavenDepository mavenDepository = this.mavenDepositoryService.getDepository(repository);

        if (mavenDepository == null) {
            return ResponseEntity.notFound().build();
        }

        String entityQualifier = RequestUtils.extractWildcard(request);
        Optional<DepositoryEntity> entityValue = mavenDepository.find(entityQualifier);
        MavenDepositoryPath project = MavenDepositoryPath.ofSystemPath(Paths.get("\\" + entityQualifier + File.separator + file.getOriginalFilename()).toString());

        Path buildDirectoryPath = Paths.get(mavenDepository.getRootFile().getPath() + File.separator + entityQualifier);
        Path buildFilePath = Paths.get(buildDirectoryPath + File.separator + file.getOriginalFilename());

        if (!entityValue.isPresent() && !StringUtils.isBlank(project.getBuildVersion())) {
            Group group = new GroupFactory(mavenDepository).obtainGroup(project.getGroupName());
            Artifact artifact = new ArtifactFactory(group).obtainArtifact(project.getArtifactName());
            Build build = new BuildFactory(artifact).obtainBuild(project.getBuildVersion());

            Files.createDirectories(buildDirectoryPath);
            FilesUtils.storeFile(buildDirectoryPath, file, false);
            FilesUtils.writeFileChecksums(buildFilePath.toAbsolutePath());

            this.mavenDepositoryService.generateMetaDataFile(mavenDepository, group, artifact, buildDirectoryPath.getParent());
            return ResponseEntity.noContent().build();
        }

        DepositoryEntity entity = entityValue.get();

        if (entity instanceof Build) {
            FilesUtils.storeFile(buildDirectoryPath, file, false);
            FilesUtils.writeFileChecksums(buildFilePath.toAbsolutePath());
            Group group = mavenDepository.getGroup(project.getGroupName());

            if (group == null) {
                return ResponseEntity.notFound().build();
            }

            this.mavenDepositoryService.generateMetaDataFile(mavenDepository, group, group.getArtifact(project.getArtifactName()), buildDirectoryPath.getParent());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.badRequest().build();
    }

}
