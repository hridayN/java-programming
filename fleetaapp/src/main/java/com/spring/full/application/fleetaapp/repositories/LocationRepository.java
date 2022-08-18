package com.spring.full.application.fleetaapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.full.application.fleetaapp.models.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
