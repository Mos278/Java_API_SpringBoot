package com.example.p3.Exception;

import org.springframework.http.HttpStatus;

public class LoginException extends BaseException {
    public LoginException(String code){
        super("Login Execption : " + code);
    }

    public static LoginException EmailisNull(){
        return new LoginException("Email is null");
        
    }

    public static LoginException PasswordisNull(){
        return new LoginException("Password is null");
       
    }

    public static LoginException PasswordisIncorrect(){
        return new LoginException("Password is Incorrect");
       
    }


}
