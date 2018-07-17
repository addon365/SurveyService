package com.addon.survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.addon.survey.model.Shop;

@RepositoryRestResource(path = "api/shops")
public interface ShopRepository extends JpaRepository<Shop, Long> {

}
