package com.codingdojo.saveTravels.services;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.saveTravels.models.Travel;
import com.codingdojo.saveTravels.repositories.TravelRepository;


@Service
public class TravelService {
	
	private final TravelRepository travelRepository;
	
	public TravelService(TravelRepository travelRepository) {
		this.travelRepository = travelRepository;
	}
	
	public List<Travel> allTravels(){
		return travelRepository.findAll();
	}
	
	public Travel createTravel(Travel t) {
		return travelRepository.save(t);
	}
	
	public Travel findTravel(Long id) {
		Optional<Travel> optionalTravel = travelRepository.findById(id);
		if(optionalTravel.isPresent()) {
			return optionalTravel.get();
		} else {
			return null;
		}
	}
	
	public Travel updateTravel(Travel t) {
		return travelRepository.save(t);
	}
	
	public void deleteTravel(Long id) {
		travelRepository.deleteById(id);
	}
	
}
