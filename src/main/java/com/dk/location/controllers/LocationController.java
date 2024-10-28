package com.dk.location.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dk.location.Util.EmailUtil;
import com.dk.location.Util.ReportUtil;
import com.dk.location.entities.Location;
import com.dk.location.repo.LocationRepository;
import com.dk.location.services.LocationServices;

@Controller
public class LocationController {

	@Autowired
	private LocationServices service;

	@Autowired
	EmailUtil emailUtil;

	@Autowired
	LocationRepository repository;

	@Autowired
	ReportUtil reportUtil;

	@Autowired
	ServletContext sc;

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}

	@RequestMapping("/saveloc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap model) {
		Location savedLocation = service.saveLocation(location);
		String msg = "location saved with id:" + savedLocation.getId();
		model.addAttribute("msg", msg);
		emailUtil.sendEmail("diwakarkaran491@gmail.com", "Location saved", "Location updated");
		return "createLocation";
	}

	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap model) {

		List<Location> locations = service.getAllLocations();
		model.addAttribute("locations", locations);
		return "displayLocations";
	}

	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id, ModelMap model) {
		// Location location = service.getLocationById(id);
		Location location = new Location();
		location.setId(id);
		service.deleteLocation(location);
		List<Location> locations = service.getAllLocations();
		model.addAttribute("locations", locations);
		return "displayLocations";
	}

	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap model) {
		Location location = service.getLocationById(id);
		model.addAttribute("location", location);
		return "updateLocation";
	}

	@RequestMapping("/updateloc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap model) {
		service.updateLocation(location);
		List<Location> locations = service.getAllLocations();
		model.addAttribute("locations", locations);
		return "displayLocations";
	}

	@RequestMapping("/generateReport")
	public String generateReport() {
		String path = sc.getRealPath("/");
		List<Object[]> data = repository.findTypeAndTypeCount();
		reportUtil.generatePieChart(path, data);
		return "report";
	}
}
