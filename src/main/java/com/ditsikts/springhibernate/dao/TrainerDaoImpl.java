package com.ditsikts.springhibernate.dao;

import com.ditsikts.springhibernate.entities.Trainer;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("trainerDao")
public class TrainerDaoImpl extends AbstractDao<Integer, Trainer> implements TrainerDao {

    @Override
    public Trainer findById(int id) {
        return getByKey(id);
    }

    @SuppressWarnings("unchecked")
    public List<Trainer> getAllTrainers() {
        Criteria criteria = createEntityCriteria();
        return (List<Trainer>) criteria.list();
    }

    @Override
    public void saveTrainer(Trainer t) {
        persist(t);
    }

    @Override
    public void deleteTrainerById(int id) {
        delete(findById(id));
    }

}
