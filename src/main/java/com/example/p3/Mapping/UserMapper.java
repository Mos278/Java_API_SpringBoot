package com.example.p3.Mapping;

import org.mapstruct.Mapper;

import com.example.p3.Entity.User;
import com.example.p3.Model.Login_Response;
import com.example.p3.Model.Register_Request;
import com.example.p3.Model.Register_Response;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Register_Response toRegister_Response(User user);

    Login_Response toLogin_Response(User user);
}
