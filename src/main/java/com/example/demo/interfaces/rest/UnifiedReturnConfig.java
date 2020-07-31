package com.example.demo.interfaces.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 統一回傳格式.
 * 2020/1/20 10:22 上午
 *
 * @author wei
 * @version 1.0.0
 **/
@Configuration
public class UnifiedReturnConfig {

    /**
     * 設置所有RestController有統一回傳格式.
     */
    @RestControllerAdvice(annotations = RestController.class)
    static class CommonResultResponseAdvice
            implements ResponseBodyAdvice<Object> {

        @Override
        public boolean supports(
                final MethodParameter methodParameter,
                final Class<? extends HttpMessageConverter<?>> aClass
        ) {
            return true;
        }

        @Override
        public Object beforeBodyWrite(
                final Object body,
                final MethodParameter methodParameter,
                final MediaType mediaType,
                final Class<? extends HttpMessageConverter<?>> aClass,
                final ServerHttpRequest serverHttpRequest,
                final ServerHttpResponse serverHttpResponse
        ) {
            if (body instanceof CommonResult) {
                return body;
            }

            return new CommonResult<>(body);
        }
    }

}
