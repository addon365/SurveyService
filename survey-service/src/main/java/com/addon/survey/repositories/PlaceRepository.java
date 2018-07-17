package com.addon.survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.addon.survey.model.Place;

@RepositoryRestResource(path = "/places")
public interface PlaceRepository extends JpaRepository<Place, Long> {

}