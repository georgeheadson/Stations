package org.example.stations.services;

import lombok.RequiredArgsConstructor;
import org.example.stations.entity.Station;
import org.example.stations.repositories.StationRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.TreeMap;

@RequiredArgsConstructor
@Service
public class StationCRUDService implements CRUDService <Station> {

    private final StationRepository repository;

    @Override
    public Station getById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Collection<Station> getAll() {
        return repository.findAll();
    }

    @Override
    public void create(Station item) {
        repository.save(item);
    }

    @Override
    public void update(Station item) {
        repository.save(item);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
