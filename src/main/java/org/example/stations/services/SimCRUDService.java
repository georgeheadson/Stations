package org.example.stations.services;

import lombok.RequiredArgsConstructor;
import org.example.stations.entity.Sim;
import org.example.stations.repositories.SimRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class SimCRUDService implements CRUDService <Sim> {

    private final SimRepository repository;

    @Override
    public Sim getById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Collection<Sim> getAll() {
        return repository.findAll();
    }

    @Override
    public void create(Sim item) {
        repository.save(item);
    }

    @Override
    public void update(Sim item) {
        repository.save(item);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
