package com.mymicroservices.user.service;

import com.mymicroservices.user.ValueObjects.Department;
import com.mymicroservices.user.ValueObjects.ReponseTemplateVo;

/*
 * @created 1/2/2021 - 3:30 PM
 * @author Swapnil Kharche
 */

import com.mymicroservices.user.entity.User;
import com.mymicroservices.user.repository.UserRepository;

import ch.qos.logback.classic.servlet.LogbackServletContainerInitializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;
    
    public User saveUser(User user) {
        log.info("In saveUser method of UserService.");
        return userRepository.save(user);
    }

	public ReponseTemplateVo getUserWithDepartment(Long userId) {
		// TODO Auto-generated method stub
		log.info("In getUserWithDepartment method of UserService.");
		ReponseTemplateVo vo = new ReponseTemplateVo();
		User user = userRepository.findByUserId(userId);
		
		Department department = 
				restTemplate.getForObject("http://localhost:9091/departments/" + user.getDepartmentId(), 
						Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		
		return vo;
	}

  

	
}
