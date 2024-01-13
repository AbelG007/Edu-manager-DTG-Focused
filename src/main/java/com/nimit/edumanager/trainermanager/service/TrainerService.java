package com.nimit.edumanager.trainermanager.service;

import com.nimit.edumanager.trainermanager.entity.Trainer;
import com.nimit.edumanager.trainermanager.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {

    @Autowired
    TrainerRepository trainerRepository;

    public Trainer create(Trainer trainer) {
        return trainerRepository.save(trainer);
    }
}
