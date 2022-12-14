package com.ant.springdemo.service;

import com.ant.springdemo.entity.User;
import com.ant.springdemo.exception.UserNotFoundException;
import com.ant.springdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //create
    public User addUser(User user){
        return userRepository.save(user);
    }

    // read user
    public User getUser(Long id){
        Optional<User> usr = userRepository.findUserById(id);
        if (usr.isPresent())
            return usr.get();
        else
            throw new UserNotFoundException("Utente con id"+id+" non trovato");
    }

    //read users
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    //update
    public User updateUser(Long id, User user){
        if (userRepository.existsById(id)){
            user.setId(id);
            return userRepository.save(user);
        }
        throw new UserNotFoundException("Utente con id"+id+" non trovato");
    }

    //delete
    public void deleteUser(Long id){
        if (userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
        }else
            System.out.println("Utente con id "+id+" non trovato");
    }
}
