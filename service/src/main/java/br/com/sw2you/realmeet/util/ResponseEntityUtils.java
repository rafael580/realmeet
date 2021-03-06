package br.com.sw2you.realmeet.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.OK;

public final class ResponseEntityUtils {

    private ResponseEntityUtils(){}

    public static <T> ResponseEntity<T> ok(T body){
            return ResponseEntity.status(OK).body(body);
    }
}
