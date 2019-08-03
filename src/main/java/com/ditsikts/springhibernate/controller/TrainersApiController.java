package com.ditsikts.springhibernate.controller;

import com.ditsikts.springhibernate.entities.Trainer;
import com.ditsikts.springhibernate.service.TrainerService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/trainersapi")
public class TrainersApiController {

    @Autowired
    TrainerService service;

    @RequestMapping(value = "/trainer/", method = RequestMethod.GET)
    public ResponseEntity<List<Trainer>> listAllUsers() {
        List<Trainer> trainers = service.getAllTrainers();
        if (trainers.isEmpty()) {
            return new ResponseEntity<List<Trainer>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Trainer>>(trainers, HttpStatus.OK);
    }

    @RequestMapping(value = "/trainer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Trainer> deleteTrainer(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting User with id " + id);

        Trainer trainer = service.findById(id);
        if (trainer == null) {
            System.out.println("Unable to delete. Trainer with id " + id + " not found");
            return new ResponseEntity<Trainer>(HttpStatus.NOT_FOUND);
        }

        service.deleteTrainerById(id);
        return new ResponseEntity<Trainer>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/trainer/", method = RequestMethod.POST)
    public ResponseEntity<Void> createTrainer(@RequestBody Trainer trainer, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Trainer " + trainer.getLastName());

        service.saveTrainer(trainer);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/trainersapi/trainer/").buildAndExpand().toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/trainer/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Trainer> updateTrainer(@PathVariable("id") int id, @RequestBody Trainer trainer) {
        System.out.println("Updating User " + id);
        if (id != trainer.getTrainerId()) {
            if (service.findById(trainer.getTrainerId()) == null) {
                service.saveTrainer(trainer);
                return new ResponseEntity<Trainer>(trainer, HttpStatus.OK);
            } else {
                return new ResponseEntity<Trainer>(HttpStatus.CONFLICT);
            }
        }

        Trainer currentTrainer = service.findById(id);
        if (currentTrainer == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Trainer>(HttpStatus.NOT_FOUND);
        }

        currentTrainer.setFirstName(trainer.getFirstName());
        currentTrainer.setLastName(trainer.getLastName());
        currentTrainer.setSubject(trainer.getSubject());

        service.updateTrainer(currentTrainer);
        return new ResponseEntity<Trainer>(currentTrainer, HttpStatus.OK);
    }

}
