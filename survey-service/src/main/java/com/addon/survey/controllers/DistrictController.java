package com.addon.survey.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.addon.survey.errors.CustomError;
import com.addon.survey.model.District;
import com.addon.survey.model.Polity;
import com.addon.survey.repositories.DistrictRepository;
import com.addon.survey.repositories.PolityRepository;

@RestController
public class DistrictController {
	@Autowired
	DistrictRepository districtRepository;
	@Autowired
	PolityRepository polityRepository;

	@GetMapping("/districts/{polityId}")
	public ResponseEntity<?> getDistricts(@PathVariable Long polityId) {
		Optional<Polity> optionalPolity = polityRepository.findById(polityId);
		if (optionalPolity.isPresent()) {
			List<District> districts = districtRepository.findDistrictsByPolity(optionalPolity.get());
			return new ResponseEntity<List<District>>(districts, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<CustomError>(new CustomError("No Polity Found"), HttpStatus.NOT_FOUND);
		}
	}

}
