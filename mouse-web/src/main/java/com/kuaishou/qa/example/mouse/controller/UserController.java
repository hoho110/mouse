package com.kuaishou.qa.example.mouse.controller;

import com.kuaishou.qa.example.mouse.entity.User;
import com.kuaishou.qa.example.mouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value="listAll")
    public List<User> listAll(){
        return userService.listAll();
    }

    @RequestMapping(value="findById")
    public User findById(@RequestParam Long id){
        User user = userService.findById(id);
        user.setRandomNum(getRandomNum());
        return user;
    }

    public int getRandomNum(){
        Random random = new Random();
        return random.nextInt();
    }
}
