package com.kuaishou.qa.example.mouse.service;

import com.kuaishou.qa.example.mouse.entity.User;
import com.kuaishou.qa.example.mouse.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public List<User> listAll(){
        return new ArrayList<User>();
    }

    public User findById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }
}
