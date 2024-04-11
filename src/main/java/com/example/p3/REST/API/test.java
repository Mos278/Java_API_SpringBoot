package com.example.p3.REST.API;
import com.example.p3.Exception.BaseException;
import com.example.p3.REST.Controller.C_test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class test {
    private C_test con;

    public test(){
        this.con = new C_test();
    }

    @GetMapping
    public String testapi() throws BaseException{
        return con.testapi();
    }

        @PostMapping("/register")
    public String register(@RequestBody String user) throws BaseException {
        // Implement logic to handle user registration (e.g., validate data, store in database)
        return "Registration successful!";
    }

    
}
