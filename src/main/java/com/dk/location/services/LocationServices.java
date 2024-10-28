package com.dk.location.services;

import java.util.List;

import com.dk.location.entities.Location;

public interface LocationServices {

	Location saveLocation(Location location);

	Location updateLocation(Location location);

	void deleteLocation(Location location);

	Location getLocationById(int id);

	List<Location> getAllLocations();

}
