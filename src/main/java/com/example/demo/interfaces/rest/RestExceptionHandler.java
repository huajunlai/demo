package com.example.demo.interfaces.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2020/7/31 下午 03:22
 *
 * @author Lai
 * @version 1.0.0
 **/
@ControllerAdvice(annotations = RestController.class)
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonResult> handleException(
            final Exception exception
    ) {
        log.error(exception.getLocalizedMessage(), exception);
        // TODO error code / msg 可抽成 enum.
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        CommonResult.fail(
                                "E0000",
                                "系統發生未知錯誤",
                                exception.getLocalizedMessage()
                        )
                );
    }

}
