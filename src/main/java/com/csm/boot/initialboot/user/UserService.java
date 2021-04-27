package com.csm.boot.initialboot.user;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }
    public void addNewUser(UserModel user) {
        if (userRepository.findUserByEmail(user.getEmail()).isPresent()) {
            throw new IllegalStateException("There already exists and account with this email");
        } else
            userRepository.save(user);
        System.out.println(user);
    }

    public void deleteStudent(Long id) {
        if(!userRepository.existsById(id))
        {
            throw new IllegalStateException("student with id:"+ id+"dosent exist");
        }
            else userRepository.deleteById(id);
    }
    @Transactional
    public void updateStudent(Long userid,String email, String password, String adress) {
        UserModel user=userRepository.findById(userid).orElseThrow(()->new IllegalStateException("user does not exist"));
        if(email!=null &&
        email.length()>0&&
        !Objects.equals(user.getEmail(),email))
        {
            if(userRepository.findUserByEmail(email).isPresent())
            {
                throw new IllegalStateException("Email already in use");
            }
            user.setEmail(email);
        }
        if(password!=null&&
        password.length()>0&&
        !Objects.equals(user.getPassword(),password))
        {
            user.setPassword(password);
        }
        if(adress!=null&&
        adress.length()>0&&
        Objects.equals(user.getAddress(),adress))
        {
            user.setAddress(adress);
        }
    }
}
