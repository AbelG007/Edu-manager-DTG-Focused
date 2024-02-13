package com.nimit.edumanager.trainermanager.controller;

import com.nimit.edumanager.trainermanager.entity.Trainer;
import com.nimit.edumanager.trainermanager.exception.TrainerNotFoundException;
import com.nimit.edumanager.trainermanager.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TrainerController {

    @Autowired
    TrainerService trainerService;

    @PostMapping(value = "/trainers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Trainer> create(@RequestBody Trainer trainer) {
        return ResponseEntity.ok(trainerService.create(trainer));
    }

    @PatchMapping(value = "/trainers/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Trainer> update(@PathVariable Long id, @RequestBody Trainer trainer) {
        try {
            return ResponseEntity.ok(trainerService.update(id, trainer));
        } catch (TrainerNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
