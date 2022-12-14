package com.ant.springdemo.controller;

import com.ant.springdemo.DataSourceConfig;
import com.ant.springdemo.entity.User;
import com.ant.springdemo.service.UserService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    /*
    @Autowired
    private DataSourceConfig dataSourceConfig;
    */
    /*
    GenericApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
    DataSourceConfig dataSourceConfig = context.getBean(DataSourceConfig.class);

     */


    //verbi http
    /*
        GET --> Read
        POST --> Create
        PUT --> Update
        DELETE --> Delete
     */
    //http://localhost:8080/user/

    //Property Injection
    @Autowired
    private UserService userService;

/*
    // Constructor Injection
    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

 */

    /*
    //Method Injection
    private final UserService userService;
    @Autowired
    public void setService(UserService userService){
        this.userService = userService;
    }

     */

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping("/allUsers")
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

    @GetMapping("/findUser/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }
}
