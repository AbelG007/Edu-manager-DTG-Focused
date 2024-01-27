package com.nimit.edumanager.securitymanager.controller;

import com.nimit.edumanager.securitymanager.entity.User;
import com.nimit.edumanager.securitymanager.exception.UserAlreadyExistsException;
import com.nimit.edumanager.securitymanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/sign-up", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> signUp(@RequestBody User appUser) {
        try {
            return ResponseEntity.ok(userService.signUpUser(appUser));
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getMessage());
        }
    }
}
