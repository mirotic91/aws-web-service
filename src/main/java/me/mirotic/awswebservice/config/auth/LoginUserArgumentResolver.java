package me.mirotic.awswebservice.config.auth;

import me.mirotic.awswebservice.config.auth.dto.SessionUser;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Objects;

@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        LoginUser isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class);
        boolean isSessionUserClass = SessionUser.class.equals(parameter.getParameterType());

        return Objects.nonNull(isLoginUserAnnotation) && isSessionUserClass;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        return webRequest.getAttribute("user", RequestAttributes.SCOPE_SESSION);
    }

}
