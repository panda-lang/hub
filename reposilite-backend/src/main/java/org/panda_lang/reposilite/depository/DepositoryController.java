package org.panda_lang.reposilite.depository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.panda_lang.reposilite.depository.build.Data;
import org.panda_lang.reposilite.utils.RequestUtils;
import org.panda_lang.panda.utilities.commons.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@ApiOperation("Operations pertaining to repository")
@RequestMapping("api/repository")
@RestController
public class DepositoryController {

    private final DepositoryServiceImpl depositoryService;

    @Autowired
    DepositoryController(DepositoryServiceImpl depositoryService) {
        this.depositoryService = depositoryService;
    }

    @ApiOperation("Print available repositories")
    @GetMapping
    public ResponseEntity<Map<String, Object>> repositories() {
        return ResponseEntity.ok(new LinkedHashMap<String, Object>() {{
            depositoryService.getNames().forEach(name -> put("name", name));
        }});
    }

    @ApiOperation("Return name of repository")
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

    @ApiOperation("Return repository entity")
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

}
