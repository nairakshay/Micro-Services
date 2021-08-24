package com.akshay.user.service;

import com.akshay.user.VO.Department;
import com.akshay.user.VO.ResponseTemplateVO;
import com.akshay.user.entity.User;
import com.akshay.user.repository.UserRepository;
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
    private RestTemplate restTemplate;//Using this we will call the DepartmentService and get the Department object

    public User saveUser(User user) {

        log.info("Inside saveUser of User Service");
        return userRepository.save(user);
    }


    public ResponseTemplateVO getUserWithDepartment(Long userId) {

        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo=new ResponseTemplateVO();
        User user=userRepository.findByUserId(userId);
        Department department=
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId()
                        ,Department.class);//Because DEPARTMENT-SERVICE is connected to th service registry
        vo.setUser(user);
        vo.setDepartment((department));
        return vo;
    }
}
