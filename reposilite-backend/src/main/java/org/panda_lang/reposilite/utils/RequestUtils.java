package org.panda_lang.reposilite.utils;

import org.panda_lang.reposilite.error.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

public final class RequestUtils {

    private static final AntPathMatcher ANT_MATCHER = new AntPathMatcher();

    public static String extractWildcard(HttpServletRequest request) {
        return extractWildcard(ANT_MATCHER, request);
    }

    public static String extractWildcard(PathMatcher matcher, HttpServletRequest request) {
        String path = request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE).toString();
        String bestMatchingPattern = request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE).toString();

        return matcher.extractPathWithinPattern(bestMatchingPattern, path);
    }

    public static ResponseEntity<?> validationError(BindingResult result) {
        return ResponseEntity.badRequest().body(new ErrorDto(400, result.getAllErrors().get(0).getDefaultMessage()));
    }

    private RequestUtils() {
    }

}
