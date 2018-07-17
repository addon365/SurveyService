package com.addon.survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.addon.survey.model.Area;

@RepositoryRestResource(path = "/areas")
public interface AreaRepository extends JpaRepository<Area, Long> {

}
