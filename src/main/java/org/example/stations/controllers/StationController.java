package org.example.stations.controllers;

import org.example.stations.StationsApplication;
import org.example.stations.entity.Station;
import org.example.stations.entity.StationType;
import org.example.stations.services.StationCRUDService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/stations")
public class StationController {

    private final StationCRUDService stationService;

    public StationController (StationCRUDService stationService) {
        this.stationService = stationService;
    }

    @GetMapping
    public String getStations(Model model) {
        model.addAttribute("stations", stationService.getAll());

        return "stations";
    }

    @GetMapping ("/{id}")
    public String getStationById(@PathVariable Integer id, Model model) {
        model.addAttribute("station", stationService.getById(id));
        model.addAttribute("stationTypeValues", StationType.values());

        return "station";
    }

    @PostMapping ("/{id}")
    public String updateStation(@PathVariable Integer id, @ModelAttribute("station") Station station) {
        station.setId(id);
        stationService.update(station);
        return "redirect:/stations";
    }

    @GetMapping ("/new")
    public String createNewStation(Model model) {
        Station station = new Station();
        model.addAttribute("station", station);
        return "newstation";
    }

    @PostMapping ("/new")
    public String createStation(@ModelAttribute("station") Station station) {
        stationService.create(station);
        return "redirect:/stations";
    }

    @GetMapping ("/delete/{id}")
    public String deleteStation(@PathVariable Integer id) {
        stationService.delete(id);
        return "redirect:/stations";
    }

}
