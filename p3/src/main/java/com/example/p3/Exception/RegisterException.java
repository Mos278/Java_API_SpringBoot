package com.example.p3.Exception;

import org.springframework.http.HttpStatus;

public class RegisterException extends BaseException{
    
    public RegisterException(String code){
        super("Register Exception:" + code);
    }

    public static RegisterException RegisNull(){
        return (RegisterException) new RegisterException("Regis is null").setStatus(HttpStatus.BAD_REQUEST);
        
    } 

    public static RegisterException EmailisNull(){
        return  new RegisterException("Email is null");
    }
}
