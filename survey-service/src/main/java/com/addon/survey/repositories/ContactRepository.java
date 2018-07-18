package com.addon.survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.addon.survey.model.Contact;

@RepositoryRestResource(path = "/contacts")
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
