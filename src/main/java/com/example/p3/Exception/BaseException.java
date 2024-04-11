package com.example.p3.Exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data

public class BaseException extends Exception {
    private HttpStatus status = HttpStatus.BAD_REQUEST;
    public BaseException(String code){
        super(code);
    }

    public BaseException setStatus(HttpStatus status) {
        this.status = status;
        return this;
    }
    
    
}
