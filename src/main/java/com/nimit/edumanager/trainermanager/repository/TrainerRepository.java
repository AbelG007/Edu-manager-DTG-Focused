package com.nimit.edumanager.trainermanager.repository;

import com.nimit.edumanager.trainermanager.entity.Trainer;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@EntityScan(basePackageClasses = Trainer.class)
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
