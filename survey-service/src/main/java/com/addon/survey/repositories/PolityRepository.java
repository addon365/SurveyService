package com.addon.survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.addon.survey.model.Polity;

@RepositoryRestResource(path = "/polities")
public interface PolityRepository extends JpaRepository<Polity, Long> {

}
