package com.javacode.Repository;


import com.javacode.Entity.ItemEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)

public interface ItemRepository extends JpaRepository<ItemEnt, String> {

}