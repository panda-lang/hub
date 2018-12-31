package org.panda_lang.reposilite.profile;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@ApiOperation("Operations pertaining to profile")
@RestController
@RequestMapping("api/account/{account}")
public class ProfileController {

    @ApiOperation("Print profile name")
    @GetMapping
    public ResponseEntity<Map<String, Object>> profile(@PathVariable @ApiParam("Account name") String account) {
        return ResponseEntity.ok(Collections.singletonMap("account", account));
    }

    @ApiOperation("Print profile and project name")
    @GetMapping("/{project}")
    public ResponseEntity<Map<String, Object>> project(@PathVariable @ApiParam("Account name") String account, @PathVariable @ApiParam("Project name") String project) {
        return ResponseEntity.ok(new LinkedHashMap<String, Object>() {{
            this.put("account", account);
            this.put("project", project);
        }});
    }

}
