package org.panda_lang.reposilite.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;

@RestController
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    private final static String ERROR_PATH = "/error";
    private final ErrorAttributes errorAttributes;

    @Autowired
    public ErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping(ERROR_PATH) // For all HTTP methods
    public ErrorDto error(WebRequest webRequest, HttpServletResponse httpServletResponse) {
        return new ErrorDto(httpServletResponse.getStatus(), this.errorAttributes.getErrorAttributes(webRequest, false).get("error").toString());
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

}
