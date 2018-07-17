package com.addon.survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.addon.survey.model.District;

@RepositoryRestResource(path = "/districts")
public interface DistrictRepository extends JpaRepository<District, Long> {

}