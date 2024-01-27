package com.nimit.edumanager.securitymanager.service;

import com.nimit.edumanager.securitymanager.entity.User;
import com.nimit.edumanager.securitymanager.exception.UserAlreadyExistsException;
import com.nimit.edumanager.securitymanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    public String signUpUser(User appUser) throws UserAlreadyExistsException {
        if (getUserByUserName(appUser.getUserName()) != null) {
            throw new UserAlreadyExistsException("Username already exists!");
        }
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        userRepository.save(appUser);
        return "User signed up successfully!";
    }

    public User getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

}
