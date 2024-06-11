package com.codingdojo.saveTravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.saveTravels.models.Travel;

public interface TravelRepository extends CrudRepository<Travel, Long>{
	List<Travel> findAll();
	

}
