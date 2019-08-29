package org.panda_lang.reposilite.utils;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public final class ResponseUtils {

    public static ResponseEntity<Object> returnFile(HttpServletResponse response, String contentType, File file) throws IOException {
        response.addHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
        response.addHeader("Content-Type", contentType);
        response.addHeader("Content-Length", Long.toString(file.length()));

        IOUtils.copy(new FileSystemResource(file).getInputStream(), response.getOutputStream());
        response.flushBuffer();

        return ResponseEntity.accepted().build();
    }

}
