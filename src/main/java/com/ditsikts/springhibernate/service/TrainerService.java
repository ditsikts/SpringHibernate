
package com.ditsikts.springhibernate.service;

import com.ditsikts.springhibernate.entities.Trainer;
import java.util.List;

public interface TrainerService {
    Trainer findById(int id);
    List<Trainer> getAllTrainers();
    void saveTrainer(Trainer t);
    public void updateTrainer(Trainer t);
    void deleteTrainerById(int id);
}
