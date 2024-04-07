package com.example.p3.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.p3.Entity.Address;
import com.example.p3.Entity.User;
import com.example.p3.Exception.BaseException;
import com.example.p3.Exception.S_AddressException;
import com.example.p3.Repository.AddressRepository;
@Service

public class AddressService {
    private final AddressRepository a_repository;

    public AddressService(AddressRepository a_repository){
        this.a_repository = a_repository;
    }

    public Address findByUser(User user)throws BaseException{
        Optional<Address> response = a_repository.findByuser(user);
        if(!response.isPresent()){
            throw S_AddressException.findByUser_NotFound();
        }
        return response.get();
    }

    public Address CreateAddress(User user ,String line1 , String line2,String zipcode) throws BaseException{
        if(Objects.isNull(user)){
          throw S_AddressException.UserisNull();
        }
        Address address = new Address();
        address.setUser(user);
        address.setLine1(line1);
        address.setLine2(line2);
        address.setZipcode(zipcode);

        a_repository.save(address);
        return address;
    }


}