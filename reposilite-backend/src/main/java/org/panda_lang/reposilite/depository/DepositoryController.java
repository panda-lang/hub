package org.panda_lang.reposilite.depository;

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

@RequestMapping("api/repository")
@RestController
public class DepositoryController {

    private final DepositoryService depositoryService;

    @Autowired
    DepositoryController(DepositoryService depositoryService) {
        this.depositoryService = depositoryService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> repositories() {
        //TODO: Return only public repositories and hidden ones as well if user is logged in and have permission to them.
        return ResponseEntity.ok(new LinkedHashMap<String, Object>() {{
            depositoryService.getNames().forEach(name -> put("name", name));
        }});
    }

    @GetMapping("/{repository}")
    public ResponseEntity<Map<String, Object>> repository(@PathVariable String repository) {
        if (this.depositoryService.getDepository(repository) == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(Collections.singletonMap("name", repository));
    }

    @GetMapping("/{repository}/**")
    public ResponseEntity<Object> repository(@PathVariable String repository, HttpServletRequest request, HttpServletResponse response) throws Exception {
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
