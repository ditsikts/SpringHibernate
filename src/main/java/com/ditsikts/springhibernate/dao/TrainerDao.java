
package com.ditsikts.springhibernate.dao;

import com.ditsikts.springhibernate.entities.Trainer;
import java.util.List;

public interface TrainerDao {
    Trainer findById(int id);
    List<Trainer> getAllTrainers();
    void saveTrainer(Trainer t);
    void deleteTrainerById(int id);
    
}
