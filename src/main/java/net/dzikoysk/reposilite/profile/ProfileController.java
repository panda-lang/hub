package net.dzikoysk.reposilite.profile;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("api/{account}")
public class ProfileController {

    @GetMapping
    public ResponseEntity<Map<String, Object>> profile(@PathVariable String account) {
        return ResponseEntity.ok(Collections.singletonMap("account", account));
    }

    @GetMapping("/{project}")
    public ResponseEntity<Map<String, Object>> project(@PathVariable String account, @PathVariable String project) {
        return ResponseEntity.ok(new LinkedHashMap<String, Object>() {{
            put("account", account);
            put("project", project);
        }});
    }

}
