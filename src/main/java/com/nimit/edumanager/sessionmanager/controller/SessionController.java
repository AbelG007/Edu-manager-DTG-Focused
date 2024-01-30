package com.nimit.edumanager.sessionmanager.controller;

import com.nimit.edumanager.sessionmanager.entity.Session;
import com.nimit.edumanager.sessionmanager.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    @Autowired
    SessionService sessionService;

    @PostMapping(value = "/sessions", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Session> create(@RequestBody Session session) {
        return ResponseEntity.ok(sessionService.create(session));
    }

}