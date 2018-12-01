package org.panda_lang.reposilite.depository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.panda_lang.reposilite.depository.artifact.Artifact;
import org.panda_lang.reposilite.depository.artifact.ArtifactFactory;
import org.panda_lang.reposilite.depository.build.Build;
import org.panda_lang.reposilite.depository.build.BuildFactory;
import org.panda_lang.reposilite.depository.build.Data;
import org.panda_lang.reposilite.depository.group.Group;
import org.panda_lang.reposilite.depository.group.GroupFactory;
import org.panda_lang.reposilite.utils.FilesUtils;
import org.panda_lang.reposilite.utils.RequestUtils;
import org.panda_lang.panda.utilities.commons.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
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

@ApiOperation("Operations pertaining to repository")
@RequestMapping("api/repository")
@RestController
public class DepositoryController {

    private final DepositoryService depositoryService;

    @Autowired
    DepositoryController(DepositoryService depositoryService) {
        this.depositoryService = depositoryService;
    }

    @ApiOperation("Prints available repositories")
    @GetMapping
    public ResponseEntity<Map<String, Object>> repositories() {
        return ResponseEntity.ok(new LinkedHashMap<String, Object>() {{
            depositoryService.getNames().forEach(name -> put("name", name));
        }});
    }

    @ApiOperation("Returns name of repository")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Repository not found"),
            @ApiResponse(code = 200, message = "Successfully returned")
    })
    @GetMapping("/{repository}")
    public ResponseEntity<Map<String, Object>> repository(@PathVariable @ApiParam("Repository name") String repository) {
        if (this.depositoryService.getDepository(repository) == null) {
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
        Depository depository = this.depositoryService.getDepository(repository);
        String entityQualifier = RequestUtils.extractWildcard(request);
        DepositoryEntity entity = depositoryService.getDepositoryEntity(depository, entityQualifier);

        if (entity == null) {
            return ResponseEntity.notFound().build();
        }

        // TODO: Resource handler
        if (entity instanceof Data) {
            response.setContentType("application/java");
            response.addHeader("Content-Disposition", "attachment; filename=\"" + entity.getName() + "\"");
            return ResponseEntity.ok(IOUtils.convertStreamToString(new FileSystemResource(((Data) entity).getFile()).getInputStream()));
        }

        File currentFile = new File(depository.getRootFile() + "/" + entityQualifier);
        return ResponseEntity.ok(new DepositoryResponse(currentFile.getPath(), currentFile.list()));
    }

    @ApiOperation("Adds artifact")
    @ApiResponses({
            @ApiResponse(code = 403, message = "File extensions not allowed"),
            @ApiResponse(code = 403, message = "Url doesn't match with Artifact's format"),
            @ApiResponse(code = 204, message = "Successfully updated")
    })
    @PutMapping("/{repository}/**")
    public ResponseEntity<Object> addArtifact(@PathVariable String repository, @RequestBody MultipartFile file, HttpServletRequest request) throws IOException {
        if (!Arrays.asList("jar", "xml", "pom").contains(FilenameUtils.getExtension(file.getOriginalFilename()))) {
            return ResponseEntity.badRequest().build();
        }

        Depository depository = this.depositoryService.getDepository(repository);
        String entityQualifier = RequestUtils.extractWildcard(request);

        DepositoryEntity entity = this.depositoryService.getDepositoryEntity(depository, entityQualifier);
        DepositoryPath project = DepositoryPath.ofSystemPath(Paths.get("\\" + entityQualifier).toString());

        Path buildDirectoryPath = Paths.get(depository.getRootFile().getPath() + File.separator + entityQualifier);

        if (entity == null && !StringUtils.isBlank(project.getBuildVersion())) {
            Group group = new GroupFactory(depository).obtainGroup(project.getGroupName());
            Artifact artifact = new ArtifactFactory(group).obtainArtifact(project.getArtifactName());
            Build build = new BuildFactory(artifact).obtainBuild(project.getBuildVersion());

            Files.createDirectories(buildDirectoryPath);
            FilesUtils.storeFile(buildDirectoryPath, file);

            return ResponseEntity.noContent().build();
        }

        if (entity instanceof Build) {
            FilesUtils.storeFile(buildDirectoryPath, file);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.badRequest().build();
    }

}
