package org.example.stations.repositories;

import org.example.stations.entity.Sim;
import org.example.stations.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimRepository extends JpaRepository <Sim, Integer> {

}
