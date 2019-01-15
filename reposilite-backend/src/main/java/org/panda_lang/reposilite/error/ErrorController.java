package org.panda_lang.reposilite.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.MessageSource;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;

@RestController
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    private final static String ERROR_PATH = "/error";
    private final ErrorAttributes errorAttributes;
    private final MessageSource messageSource;

    @Autowired
    public ErrorController(ErrorAttributes errorAttributes, MessageSource messageSource) {
        this.errorAttributes = errorAttributes;
        this.messageSource = messageSource;
    }

    @RequestMapping(ERROR_PATH) // For all HTTP methods
    public ErrorDto error(WebRequest webRequest, HttpServletResponse httpServletResponse) {
        Map<String, Object> errorAttributes = this.errorAttributes.getErrorAttributes(webRequest, false);

        if (httpServletResponse.getStatus() == 400 && errorAttributes.get("errors") != null) {
            Collection<FieldError> errors = (Collection<FieldError>) errorAttributes.get("errors");

            return new ErrorDto(400, errors.stream()
                    .map(fieldError -> this.messageSource.getMessage(fieldError, Locale.getDefault()))
                    .findFirst()
                    .get());
        }

        return new ErrorDto(httpServletResponse.getStatus(), errorAttributes.get("error").toString());
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

}
