package com.csm.boot.initialboot.user;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository
        extends JpaRepository<UserModel,Long> {
    //Select * From user Where email=?
    //@Query("SELECT s FROM user s WHERE s.email=1?")
    Optional<UserModel> findUserByEmail(String email);


}
