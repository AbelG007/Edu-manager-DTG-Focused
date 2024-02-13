package com.nimit.edumanager.trainermanager.service;

import com.nimit.edumanager.trainermanager.entity.Trainer;
import com.nimit.edumanager.trainermanager.exception.TrainerNotFoundException;
import com.nimit.edumanager.trainermanager.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TrainerService {

    @Autowired
    TrainerRepository trainerRepository;

    public Trainer create(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    public List<Trainer> fetchAllTrainers() {
        return trainerRepository.findAll();
    }

    public Trainer getById(Long id) throws TrainerNotFoundException {
        return trainerRepository.findById(id).orElseThrow(() -> new TrainerNotFoundException("Trainer with id " + id + "not found"));
    }

    public Trainer update(Long id, Trainer trainer) throws TrainerNotFoundException {
        Trainer trainerFromDb = getById(id);
        trainerFromDb.setFirstName(trainer.getFirstName());
        trainerFromDb.setLastName(trainer.getLastName());
        trainerFromDb.setType(trainer.getType());
        trainerFromDb.setJoiningDate(trainer.getJoiningDate());
        trainerFromDb.setTerminationDate(trainer.getTerminationDate());
        trainerFromDb.setExperience(trainer.getExperience());
        trainerFromDb.setSalary(trainer.getSalary());
        return trainerRepository.save(trainerFromDb);
    }

}
