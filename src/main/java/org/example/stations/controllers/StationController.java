package org.example.stations.controllers;

import org.example.stations.entity.Station;
import org.example.stations.services.StationCRUDService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/stations")
public class StationController {

    private final StationCRUDService stationService;

    public StationController (StationCRUDService stationService) {
        this.stationService = stationService;
    }

    @GetMapping
    public ModelAndView getStations() {
        List<String> items = new ArrayList<String>();
        for (Station station : stationService.getAll()) {
            items.add(station.getName() + " - " + station.getMac());
        }

        ModelAndView retVal = new ModelAndView();
        retVal.setViewName("stations");
        retVal.addObject("items", items);

        return retVal;
        //return stationService.getAll();
    }

    @GetMapping ("/{id}")
    public Station getStationById(@PathVariable Integer id) {
        return stationService.getById(id);
    }

    @PostMapping
    public void createStation(@RequestBody Station station) {
        stationService.create(station);
    }

    @PutMapping ("/{id}")
    public void updateStation(@PathVariable Integer id, @RequestBody Station station) {
        station.setId(id);
        stationService.update(station);
    }

    @DeleteMapping ("/{id}")
    public void deleteStation(@PathVariable Integer id) {
        stationService.delete(id);
    }

}
