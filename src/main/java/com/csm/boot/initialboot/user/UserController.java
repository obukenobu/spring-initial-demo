package com.csm.boot.initialboot.user;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserModel> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public void registerUser(@RequestBody UserModel user) {
        userService.addNewUser(user);
    }

    @DeleteMapping(path = "{id}")
    public void removeUser(@PathVariable("id") Long id)
    {
        userService.deleteStudent(id);
    }
    @PutMapping(path = "{id}")
    public void updateUser(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String adress)
    {
        userService.updateStudent(id,email,password,adress);
    }

}
