package com.example.p3.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.p3.Entity.Address;
import com.example.p3.Entity.User;

import java.util.Optional;



@Repository
public interface AddressRepository extends CrudRepository<Address,String> {
    Optional<Address> findByid(String id);
    Optional<Address> findByline1(String line1);
    Optional<Address> findByline2(String line2);
    Optional<Address> findByzipcode(String zipcode);
    Optional<Address> findByuser(User user);

    //boolean existsByEmail(String email);//Search Email dup
    
    
}
