package com.addon.survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.addon.survey.model.Building;

@RepositoryRestResource(path = "/buildings")
public interface BuildingRepository extends JpaRepository<Building, Long> {

}
