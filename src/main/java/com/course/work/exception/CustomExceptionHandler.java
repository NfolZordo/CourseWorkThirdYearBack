package com.course.work.exception;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        if (ex instanceof ExpiredJwtException) {
            log.error("JWT token has expired");
            return handleExpiredJwtException(request, (ExpiredJwtException) ex);
        }
        log.error("JWT token has expired");
        return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        log.error("JWT token has expired");
        return handleExceptionInternal(ex, null, headers, status, request);
    }

    @ExceptionHandler(value = ExpiredJwtException.class)
    protected ResponseEntity<Object> handleExpiredJwtException(WebRequest request, ExpiredJwtException ex) {
        log.error("JWT token has expired");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("JWT token has expired");
    }
//    @Override
//    public ResponseEntity<Object> handleException(Exception ex, WebRequest request) {
//        if (ex instanceof ExpiredJwtException) {
//            return handleExpiredJwtException((ExpiredJwtException) ex, request);
//        }
//        // обробка інших помилок
//        return super.handleException(ex, request);
//    }
//
//    private ResponseEntity<Object> handleExpiredJwtException(ExpiredJwtException ex, WebRequest request) {
//        // код для обробки помилки ExpiredJwtException
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("JWT token has expired");
//    }

}