package org.panda_lang.reposilite.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class WhitelabelController implements ErrorController {

    private final static String ERROR_PATH = "/error";
    private final ErrorAttributes errorAttributes;

    @Autowired
    public WhitelabelController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping(ERROR_PATH) // For all HTTP methods
    public ErrorContent error(WebRequest webRequest, HttpServletResponse httpServletResponse) {
        return new ErrorContent(httpServletResponse.getStatus(), this.errorAttributes.getErrorAttributes(webRequest, false));
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    private static class ErrorContent {

        String timestamp;
        String error;
        String path;
        int status;

        ErrorContent(int status, Map<String, Object> errorAttributes) {
            this.timestamp = String.valueOf(errorAttributes.get("timestamp"));
            this.error = String.valueOf(errorAttributes.get("error"));
            this.path = String.valueOf(errorAttributes.get("path"));
            this.status = status;
        }

        public String getTimestamp() {
            return this.timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public String getPath() {
            return this.path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

    }

}
