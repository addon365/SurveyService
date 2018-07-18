package com.addon.survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addon.survey.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
