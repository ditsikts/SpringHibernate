package com.ditsikts.springhibernate.controller;

import com.ditsikts.springhibernate.entities.Trainer;
import com.ditsikts.springhibernate.service.TrainerService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/trainers")
public class TrainersController {

    @Autowired
    TrainerService service;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model) {
        List<Trainer> trainers = service.getAllTrainers();
        System.out.println(trainers);
        model.addAttribute("trainers", trainers);
        return "trainer/index";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTrainer(@PathVariable("id") int id, ModelMap model) {
        service.deleteTrainerById(id);
        model.addAttribute("message", "Delete Trainer");
        return "trainer/info";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createTrainer(ModelMap model) {
        Trainer t = new Trainer();
        model.addAttribute("title", "Create Trainer");
        model.addAttribute("trainer", t);
        return "trainer/createOrUpdate";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateTrainer(@PathVariable("id") int id, ModelMap model) {

        Trainer t = service.findById(id);

        model.addAttribute("trainer", t);
        model.addAttribute("title", "Update Trainer");
        return "trainer/createOrUpdate";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveTrainer(@ModelAttribute("trainer") Trainer trainer, ModelMap model) {
//        System.out.println(trainer);

        if (trainer.getTrainerId() == null) {
            service.saveTrainer(trainer);
            model.addAttribute("message", "Save Trainer");

        } else {
            service.updateTrainer(trainer);
            model.addAttribute("message", "Update Trainer");

        }
        return "trainer/info";
    }

}
