package com.example.p3.Exception;

import org.springframework.http.HttpStatus;

public class S_UserException extends BaseException {
    public S_UserException(String code){ 
        super("Service User Execption: " + code);
    }

    public static S_UserException S_User_EmailisNull(){
        return new S_UserException("Email is null");
        
    }

    public static S_UserException S_User_PWisNull(){
        return new S_UserException("password is null");
        
    }

    public static S_UserException S_User_NameisNull(){
        return new S_UserException("name is null");
        
    }

    public static S_UserException S_User_EmailDuplicated(){
        return new S_UserException("Duplicated Email");
  
    }

    public static S_UserException S_User_EmailnoMatch(){
        return new S_UserException("Can't Matching");
       
    }

    public static S_UserException S_User_IdNotFound(){
        return new S_UserException("Id User not found");
    }
}
