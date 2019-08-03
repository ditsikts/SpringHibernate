package com.ditsikts.springhibernate.service;

import com.ditsikts.springhibernate.dao.TrainerDao;
import com.ditsikts.springhibernate.entities.Trainer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("trainerService")
@Transactional
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerDao dao;

    @Override
    public Trainer findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Trainer> getAllTrainers() {
        return dao.getAllTrainers();
    }

    @Override
    public void saveTrainer(Trainer t) {
        dao.saveTrainer(t);
    }

    @Override
    public void deleteTrainerById(int id) {
        dao.deleteTrainerById(id);
    }

    @Override
    public void updateTrainer(Trainer t) {
        Trainer entity = dao.findById(t.getTrainerId());
        if (entity != null) {
            entity.setFirstName(t.getFirstName());
            entity.setLastName(t.getLastName());
            entity.setSubject(t.getSubject());
        }
    }

}
