package br.com.ford.theplenos.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.ford.theplenos.exception.BigQuerySearchException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ExceptionHandler {

    private static final String HANDLED_ACTION_FIELD_LOG_TEMPLATE = "handled_action={}";

    @org.springframework.web.bind.annotation.ExceptionHandler({ BigQuerySearchException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected String handleSearchException(final RuntimeException exception) {
        return logExceptionAndGetMessage("big_query_failure_clause", exception);
    }
    
    @org.springframework.web.bind.annotation.ExceptionHandler({ RecordNotFoundException.class })
    public ResponseEntity<String> handleRecordNotFoundException(RecordNotFoundException ex) {
        System.out.println("Exceção capturada: " + ex.getMessage()); // Log

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NO_CONTENT);
    }


    private String logExceptionAndGetMessage(final String actionName, final Exception exception) {
        log.warn(HANDLED_ACTION_FIELD_LOG_TEMPLATE, actionName, exception);
        return exception.getMessage();
    }
	
}
