package org.example.stations.controllers;

import org.example.stations.entity.Sim;
import org.example.stations.services.SimCRUDService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/sims")
public class SimController {

    private final SimCRUDService simService;

    public SimController (SimCRUDService simService) {
        this.simService = simService;
    }

    @GetMapping
    public Collection<Sim> getSims(){
        return simService.getAll();
    }

    @GetMapping ("/{id}")
    public Sim getSimById(@PathVariable Integer id){
        return simService.getById(id);
    }

    @PostMapping
    public void createSim(@RequestBody Sim sim) {
        simService.create(sim);
    }

    @PutMapping ("/{id}")
    public void updateSim(@PathVariable Integer id, @RequestBody Sim sim){
        sim.setId(id);
        simService.update(sim);
    }

    @DeleteMapping ("/{id}")
    public void deleteSim(@PathVariable Integer id){
        simService.delete(id);
    }

}
