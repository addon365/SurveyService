package com.addon.survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addon.survey.model.Polity;

public interface PolityRepository extends JpaRepository<Polity, Long> {

}
