package com.addon.survey.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addon.survey.model.District;
import com.addon.survey.model.Polity;

public interface DistrictRepository extends JpaRepository<District, Long> {

	List<District> findDistrictsByPolity(Polity polity);
}