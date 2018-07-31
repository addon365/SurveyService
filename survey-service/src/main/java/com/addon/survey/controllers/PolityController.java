package com.addon.survey.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addon.survey.model.Polity;
import com.addon.survey.repositories.PolityRepository;

@RestController
public class PolityController {
	@Autowired
	private PolityRepository polityRepository;

	@GetMapping("/polities")
	public List<Polity> getPolities() {
		return polityRepository.findAll();
	}
}
