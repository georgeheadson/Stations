package org.example.stations.controllers;

import org.example.stations.entity.Station;
import org.example.stations.services.StationCRUDService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/stations")
public class StationController {

    private final StationCRUDService stationService;

    public StationController (StationCRUDService stationService) {
        this.stationService = stationService;
    }

    @GetMapping
    public Collection<Station> getStations(){
        return stationService.getAll();
    }

    @GetMapping ("/{id}")
    public Station getStationById(@PathVariable Integer id){
        return stationService.getById(id);
    }

    @PostMapping
    public void createStation(@RequestBody Station station) {
        stationService.create(station);
    }

    @PutMapping ("/{id}")
    public void updateStation(@PathVariable Integer id, @RequestBody Station station){
        station.setId(id);
        stationService.update(station);
    }

    @DeleteMapping ("/{id}")
    public void deleteStation(@PathVariable Integer id){
        stationService.delete(id);
    }

}
