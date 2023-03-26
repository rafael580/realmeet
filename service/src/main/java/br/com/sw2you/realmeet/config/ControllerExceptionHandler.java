package br.com.sw2you.realmeet.config;

import br.com.sw2you.realmeet.api.model.ResponseError;
import br.com.sw2you.realmeet.exception.RoomNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(RoomNotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(Exception exception){
            return buildResponseEntity(HttpStatus.NOT_FOUND,exception);
    }

    private ResponseEntity<Object> buildResponseEntity(HttpStatus Httpstatus,Exception e){
        return new ResponseEntity<>(
                new ResponseError()
                        .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                        .code(HttpStatus.NOT_FOUND.value())
                        .message(e.getMessage()),
                        Httpstatus
        );
    }
}
