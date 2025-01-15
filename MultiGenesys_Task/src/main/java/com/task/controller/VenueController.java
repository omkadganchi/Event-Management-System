package com.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.dto.VenueDTO;
import com.task.service.VenueService;

@RestController
@RequestMapping("/api/venue")
public class VenueController {

	@Autowired
	VenueService venueService;
	
	@PostMapping("/create-venue")
	public ResponseEntity<VenueDTO> createOrganizer(@RequestBody VenueDTO venueDTO) {
		return ResponseEntity.ok(venueService.createOrganizer(venueDTO));
	}
	
	@GetMapping("/get-venue-by-id/{id}")
    public ResponseEntity<VenueDTO> getVenueById(@PathVariable int id) {
        return ResponseEntity.ok(venueService.getVenueById(id));
    }
	
	@PutMapping("/update-venue/{id}")
	public ResponseEntity<VenueDTO> updateVenue(@PathVariable int id, @RequestBody VenueDTO venueDTO) {
		return ResponseEntity.ok(venueService.updateVenue(id,venueDTO));
	}
	
	@DeleteMapping("/delete-venue/{id}")
	public ResponseEntity<String> deleteVenue(@PathVariable int id) {
		return ResponseEntity.ok(venueService.deleteVenue(id));
	}
}
