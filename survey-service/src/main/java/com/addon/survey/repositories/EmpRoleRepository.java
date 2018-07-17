package com.addon.survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.addon.survey.model.EmpRole;

@RepositoryRestResource(path = "/roles")
public interface EmpRoleRepository extends JpaRepository<EmpRole, Long> {

}
