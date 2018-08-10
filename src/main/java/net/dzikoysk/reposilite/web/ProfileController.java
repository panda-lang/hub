package net.dzikoysk.reposilite.web;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.support.HandlerMethodArgumentResolverComposite;
import org.springframework.web.method.support.InvocableHandlerMethod;
import org.springframework.web.servlet.handler.AbstractHandlerMapping;

import javax.servlet.http.HttpServletRequest;

public class ProfileController extends AbstractHandlerMapping {

    private final HandlerMethodArgumentResolverComposite argumentResolvers;

    public ProfileController(HandlerMethodArgumentResolverComposite argumentResolvers) {
        this.argumentResolvers = argumentResolvers;
    }

    @Override
    protected Object getHandlerInternal(HttpServletRequest request) throws Exception {
        InvocableHandlerMethod handlerMethod = new InvocableHandlerMethod(this, getClass().getMethod("profile", HttpServletRequest.class));
        handlerMethod.setHandlerMethodArgumentResolvers(argumentResolvers);
        return handlerMethod;
    }

    @ResponseBody
    public String profile(HttpServletRequest request) {
        return "Profile: " + request.getRequestURI();
    }

}
