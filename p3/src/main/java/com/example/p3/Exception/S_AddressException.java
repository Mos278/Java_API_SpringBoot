package com.example.p3.Exception;

public class S_AddressException extends BaseException{
    public S_AddressException(String code){
        super("Address Service Execption : " + code);
    }

    public static S_AddressException findByUser_NotFound(){
        return new S_AddressException("find by User Not Found");
        
    }

    public static S_AddressException CreateAddress_LinemoreLimit(){
        return new S_AddressException("Create Address Line More than 2");
    }

    public static S_AddressException UserisNull(){
        return new S_AddressException("User is Null");
    }

    
    
}
