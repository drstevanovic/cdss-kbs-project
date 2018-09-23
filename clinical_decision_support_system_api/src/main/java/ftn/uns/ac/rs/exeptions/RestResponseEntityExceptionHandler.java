package ftn.uns.ac.rs.exeptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Optional;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {MyValidationFormException.class})
    protected ResponseEntity<Object> notValidFormParams(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        bodyOfResponse = Optional.ofNullable(bodyOfResponse).orElse("Validation error in form");
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE, request);
    }

    @ExceptionHandler(value = {MyNotFoundExeption.class})
    protected ResponseEntity<Object> notExistHandle(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        bodyOfResponse = Optional.ofNullable(bodyOfResponse).orElse("The object not found");
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {MyBadUserExeption.class})
    protected ResponseEntity<Object> badUserHandle(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        bodyOfResponse = Optional.ofNullable(bodyOfResponse).orElse("Bad user");
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = {MyAlreadyExistsException.class})
    protected ResponseEntity<Object> alreadyExistsHandle(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        bodyOfResponse = Optional.ofNullable(bodyOfResponse).orElse("Already exists in database");
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = {MySavingInRepoException.class})
    protected ResponseEntity<Object> savingFailureHandle(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        bodyOfResponse = Optional.ofNullable(bodyOfResponse).orElse("Saving in repository failed");
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.EXPECTATION_FAILED, request);
    }

    @ExceptionHandler(value = {MyDeletingInRepoException.class})
    protected ResponseEntity<Object> deletingFailureHandle(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        bodyOfResponse = Optional.ofNullable(bodyOfResponse).orElse("Deleting in repository failed");
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.EXPECTATION_FAILED, request);
    }

    @ExceptionHandler(value = {MyNullPointerException.class})
    protected ResponseEntity<Object> nullHandle(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        bodyOfResponse = Optional.ofNullable(bodyOfResponse).orElse("Object is null");
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NO_CONTENT, request);
    }

    @ExceptionHandler(value = {MyInvalidRequestException.class})
    protected ResponseEntity<Object> invalidRequest(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        bodyOfResponse = Optional.ofNullable(bodyOfResponse).orElse("Invalid request");
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {MyBadParsingException.class})
    protected ResponseEntity<Object> badParsing(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        bodyOfResponse = Optional.ofNullable(bodyOfResponse).orElse("Invalid parse");
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE, request);
    }

    @ExceptionHandler(value = {MyAccessDeniedException.class})
    protected ResponseEntity<Object> accessDenied(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        bodyOfResponse = Optional.ofNullable(bodyOfResponse).orElse("Access denied");
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }


}