package com.addon.survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.addon.survey.model.Taluk;

@RepositoryRestResource(path = "api/taluks")
public interface TalukRepository extends JpaRepository<Taluk, Long> {

}