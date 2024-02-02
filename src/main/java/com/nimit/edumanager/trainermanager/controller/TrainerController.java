package com.nimit.edumanager.trainermanager.controller;

import com.nimit.edumanager.trainermanager.entity.Trainer;
import com.nimit.edumanager.trainermanager.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainerController {

    @Autowired
    TrainerService trainerService;

    @PostMapping(value = "/trainers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Trainer> create(@RequestBody Trainer trainer) {
        return ResponseEntity.ok(trainerService.create(trainer));
    }

}
