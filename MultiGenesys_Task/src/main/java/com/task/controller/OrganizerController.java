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

import com.task.dto.OrganizerDTO;
import com.task.service.OrganizerService;

@RestController
@RequestMapping("/api/organizer")
public class OrganizerController {

	@Autowired
	OrganizerService organizerService;
	
	@PostMapping("/create-organizer")
	public ResponseEntity<OrganizerDTO> createOrganizer(@RequestBody OrganizerDTO organizerDTO) {
		return ResponseEntity.ok(organizerService.createOrganizer(organizerDTO));
	}
	
	@GetMapping("/get-organizer-by-id/{id}")
	public ResponseEntity<OrganizerDTO> getOrganizerById(@PathVariable int id) {
		return ResponseEntity.ok(organizerService.getOrganizerById(id));
	}
	
	@PutMapping("/update-organizer/{id}")
	public ResponseEntity<OrganizerDTO> updateOrganizer(@PathVariable int id, @RequestBody OrganizerDTO organizerDTO) {
		return ResponseEntity.ok(organizerService.updateOrganizer(id, organizerDTO));
	}
	
	@DeleteMapping("/delete-organizer/{id}")
	public ResponseEntity<String> deleteorganizer(@PathVariable int id) {
		return ResponseEntity.ok(organizerService.deleteOrganizer(id));
	}
}
