package com.akshay.user.controller;

import com.akshay.user.VO.ResponseTemplateVO;
import com.akshay.user.entity.User;
import com.akshay.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(User user){

         log.info("Inside saveUser of User Controller");
         return userService.saveUser(user);
    }

    @GetMapping("{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){

        log.info("Inside getUserIdWithDepartment of User Controller");
        return userService.getUserWithDepartment(userId);
    }
}
