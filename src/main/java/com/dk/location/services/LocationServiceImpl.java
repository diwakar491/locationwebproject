package com.dk.location.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dk.location.entities.Location;
import com.dk.location.repo.LocationRepository;

@Service
public class LocationServiceImpl implements LocationServices {

	
	@Autowired
	private LocationRepository repository;
	
	@Override
	public Location saveLocation(Location location) {
		return repository.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return repository.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		repository.delete(location);
	}

	@Override
	public Location getLocationById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Location> getAllLocations() {
		return repository.findAll();
	}

}
