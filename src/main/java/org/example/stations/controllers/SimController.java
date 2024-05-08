package org.example.stations.controllers;

import org.example.stations.entity.Sim;
import org.example.stations.entity.Station;
import org.example.stations.entity.StationType;
import org.example.stations.services.SimCRUDService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/sims")
public class SimController {

    private final SimCRUDService simService;

    public SimController (SimCRUDService simService) {
        this.simService = simService;
    }

    @GetMapping
    public String getSims(Model model) {
        model.addAttribute("sims", simService.getAll());

        return "sims";
    }

    @GetMapping ("/{id}")
    public String getSimById(@PathVariable Integer id, Model model) {
        model.addAttribute("sim", simService.getById(id));

        return "sim";
    }

    @PostMapping ("/{id}")
    public String updateSim(@PathVariable Integer id, @ModelAttribute("sim") Sim sim) {
        sim.setId(id);
        simService.update(sim);

        return "redirect:/sims";
    }

    @GetMapping ("/new")
    public String createNewSim(Model model) {
        Sim sim = new Sim();
        model.addAttribute("sim", sim);

        return "newsim";
    }

    @PostMapping ("/new")
    public String createSim(@ModelAttribute("sim") Sim sim) {
        simService.create(sim);

        return "redirect:/sims";
    }

    @GetMapping ("/delete/{id}")
    public String deleteSim(@PathVariable Integer id) {
        simService.delete(id);

        return "redirect:/sims";
    }


}
