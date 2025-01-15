package com.task.controller;



import java.util.List;

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

import com.task.dto.EventDTO;
import com.task.service.EventService;

@RestController
@RequestMapping("/api/event")
public class EventController {

	@Autowired
	EventService eventService;

	@PostMapping("/create-event")
	public ResponseEntity<EventDTO> createEvent(@RequestBody EventDTO eventDTO) {
		return ResponseEntity.ok(eventService.createEvent(eventDTO));
	}

	@GetMapping("/get-all-events")
	public ResponseEntity<List<EventDTO>> getAllEvents() {
		return ResponseEntity.ok(eventService.getAllEvents());
	}

	@GetMapping("/get-event-by-id/{id}")
	public ResponseEntity<EventDTO> getEventById(@PathVariable int id) {
		return ResponseEntity.ok(eventService.getEventById(id));
	}
	
	@PutMapping("/update-event/{id}")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable int id, @RequestBody EventDTO eventDTO) {
        return ResponseEntity.ok(eventService.updateEvent(id, eventDTO));
    }
	
	@DeleteMapping("/delete-event/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable int id) {
		 return ResponseEntity.ok(eventService.deleteEvent(id));
    }
	
	@GetMapping("/get-events-by-venue/{venueId}")
	public ResponseEntity<List<EventDTO>> getEventsByVenue(@PathVariable int venueId) {
        return ResponseEntity.ok(eventService.getEventsByVenue(venueId));
    }
	
	@GetMapping("/get-events-by-organizer/{organizerId}")
    public ResponseEntity<List<EventDTO>> getEventsByOrganizer(@PathVariable int organizerId) {
        return ResponseEntity.ok(eventService.getEventsByOrganizer(organizerId));
    }
}
