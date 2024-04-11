package com.example.p3.REST.API;

import org.springframework.web.bind.annotation.RestController;
import com.example.p3.Exception.BaseException;
import com.example.p3.Model.Register_Request;
import com.example.p3.Model.Register_Response;
import com.example.p3.REST.Controller.C_Register;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController

public class Register {
    private final C_Register con;
    public Register(C_Register con){
       this.con = con;
    }

    @PostMapping("/Register")
    public ResponseEntity<Register_Response> postMethodName(@RequestBody Register_Request entity)  throws BaseException{
        Register_Response response = con.Register(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
