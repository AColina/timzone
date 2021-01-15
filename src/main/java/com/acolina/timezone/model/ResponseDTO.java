package com.acolina.timezone.model;

import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

@Data
public class ResponseDTO<T> implements Serializable {

    private T response;

    public static <T> ResponseEntity<ResponseDTO<T>> ok(T object) {
        ResponseDTO<T> dto = new ResponseDTO<>();
        dto.response = object;
        return ResponseEntity.ok(dto);
    }
}