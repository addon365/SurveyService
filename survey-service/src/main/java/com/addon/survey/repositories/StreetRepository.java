package com.addon.survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.addon.survey.model.Street;

@RepositoryRestResource(path = "api/streets")
public interface StreetRepository extends JpaRepository<Street, Long> {

}
