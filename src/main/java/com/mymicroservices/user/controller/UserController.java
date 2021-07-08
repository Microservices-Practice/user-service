package com.mymicroservices.user.controller;

import com.mymicroservices.user.ValueObjects.ReponseTemplateVo;

/*
 * @created 1/2/2021 - 3:31 PM
 * @author Swapnil Kharche
 */

import com.mymicroservices.user.entity.User;
import com.mymicroservices.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("In saveUser method of userController.");
        return userService.saveUser(user);
    }
    
    @GetMapping("/{id}")
    public ReponseTemplateVo getUserWithDepartment(@PathVariable("id") Long userId) {  	
    	log.info("In getUserWithDepartment method of userController.");
    	return userService.getUserWithDepartment(userId);
    }

   
}
 