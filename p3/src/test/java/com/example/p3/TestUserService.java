package com.example.p3;


import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.example.p3.Entity.Address;
import com.example.p3.Entity.Social;
import com.example.p3.Entity.User;
import com.example.p3.Exception.BaseException;
import com.example.p3.Service.AddressService;
import com.example.p3.Service.SocialService;
import com.example.p3.Service.TestService;
import com.example.p3.Service.UserService;

import jakarta.transaction.Transactional;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@Rollback
@Transactional
public class TestUserService {

    @Autowired
    private  UserService userservice;
    @Autowired
    private SocialService socialService;
    @Autowired
    private AddressService addressservice;

    @Autowired
    private TestService testService;

  
    @Test
    @Order(1)
    @Rollback(false)
    void testCreate() throws BaseException{
        User user = userservice.Create(Data.email, Data.password, Data.name);
        //check null
        Assertions.assertNotNull(user);
        Assertions.assertNotNull(user.getId());
        Assertions.assertEquals(user.getEmail(), Data.email);
        

        //check equals
        Assertions.assertEquals(Data.email, user.getEmail());
        testService.PrintString(" Create Success");
    }

    
    @Test
    @Order(3)
    @Rollback(false)
    void testCreateSocial()throws BaseException{
       User user = userservice.Login_User(Data.email, Data.password);
       Social social = socialService.CreateSocial(user, TestSocialData.facebook, TestSocialData.ig);
       Assertions.assertNotNull(social);
       Assertions.assertEquals(user, social.getUser());
       Assertions.assertEquals(social.getFacebook(),TestSocialData.facebook);
       Assertions.assertEquals(social.getIg(), TestSocialData.ig);
       testService.PrintString(" CreateSocial Success");
    }



    
    @Test
    @Order(4)
    @Rollback(false)

    void TestCreateAddress()throws BaseException{
        
        User user = userservice.Login_User(Data.email, Data.password);
        Assertions.assertTrue(user.getAddress().isEmpty());
        Address address1 = addressservice.CreateAddress(user, TestCreateAddress1.line1, TestCreateAddress1.line2, TestCreateAddress1.zipcode);
        Assertions.assertNotNull(address1);
        Assertions.assertEquals(user, address1.getUser());
        Assertions.assertEquals(address1.getLine1(), TestCreateAddress1.line1);
        Assertions.assertEquals(address1.getLine2(), TestCreateAddress1.line2);
        Assertions.assertEquals(address1.getZipcode(), TestCreateAddress1.zipcode);
        Address address2 = addressservice.CreateAddress(user, TestCreateAddress2.line1, TestCreateAddress2.line2, TestCreateAddress2.zipcode);
        Assertions.assertNotNull(address2);
        Assertions.assertEquals(user, address2.getUser());
        Assertions.assertEquals(address2.getLine1(), TestCreateAddress2.line1);
        Assertions.assertEquals(address2.getLine2(), TestCreateAddress2.line2);
        Assertions.assertEquals(address2.getZipcode(), TestCreateAddress2.zipcode);
        Assertions.assertTrue(!(address1.getId() == address2.getId())); 
    }


    
    @Test
    @Order(5)
    @Rollback(true)
    void TestCheckTransection()throws BaseException{
        User user = userservice.Login_User(Data.email, Data.password);
        Assertions.assertEquals(user.getAddress().size(),2);
        Assertions.assertEquals(user.getAddress().get(0).getLine1(),TestCreateAddress1.line1);
        Assertions.assertEquals(user.getAddress().get(1).getLine1(),TestCreateAddress2.line1);

    }




    @Test
    @Order(10)
    @Rollback(false)
    void testDeleteUser() throws BaseException{
        //User user = userservice.Login_User(Data.email, Data.password);
        //socialService.DeleteSocial(user);//auto delete relationship
        User user = userservice.Login_User(Data.email, Data.password);
        userservice.DeleteUser(user);
        testService.PrintString(" Delete Success");
        
    }


    interface Data{
        String email = "nat@test2.com";

        String password = "me1234";

        String name = "mos";
    }

    interface UpdateData{
        String name = "Nate";
    }



    interface TestSocialData{
        String facebook = "facebook 1";
        String ig = "ig";
    }
    
    interface TestCreateAddress1{
        String line1 = "123";
        String line2 = "";
        String zipcode = "500145";
    }

    interface TestCreateAddress2{
        String line1 = "456";
        String line2 = "556";
        String zipcode = "088712";
    }
}
