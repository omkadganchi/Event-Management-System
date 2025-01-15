package com.task.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.task.dao.EventRepository;
import com.task.dao.OrganizerRepository;
import com.task.dao.VenueRepository;
import com.task.dto.EventDTO;
import com.task.entity.Event;
import com.task.entity.Organizer;
import com.task.entity.Venue;
import com.task.exception.ResourceNotFoundException;
import com.task.util.MapUtil;

@Service
public class EventService {

	@Autowired
	EventRepository eventRepository;

	@Autowired
	VenueRepository venueRepository;

	@Autowired
	OrganizerRepository organizerRepository;

	@Transactional
	public EventDTO createEvent(EventDTO eventDTO) {
		Venue venue = venueRepository.findById(eventDTO.getVenueId())
				.orElseThrow(() -> new ResourceNotFoundException("Venue not found"));
		Organizer organizer = organizerRepository.findById(eventDTO.getOrganizerId())
				.orElseThrow(() -> new ResourceNotFoundException("Organizer not found"));
		Event event = MapUtil.toEventEntity(eventDTO, venue, organizer);
		event = eventRepository.save(event);
		return MapUtil.toEventDTO(event);
	}

	@Transactional(readOnly = true)
	public List<EventDTO> getAllEvents() {
		return eventRepository.findAll().stream().map(MapUtil::toEventDTO).toList();
	}

	@Transactional(readOnly = true)
	public EventDTO getEventById(int id) {
		return eventRepository.findById(id).map(MapUtil::toEventDTO)
				.orElseThrow(() -> new ResourceNotFoundException("Event not found with ID: " + id));
	}

	@Transactional
	public EventDTO updateEvent(int id, EventDTO eventDTO) {
		Venue venue = venueRepository.findById(eventDTO.getOrganizerId())
				.orElseThrow(() -> new ResourceNotFoundException("Venue not found"));
		Organizer organizer = organizerRepository.findById(eventDTO.getOrganizerId())
				.orElseThrow(() -> new ResourceNotFoundException("Organizer not found"));
		return eventRepository.findById(id).map(existEvent -> {
			existEvent.setEventName(eventDTO.getEventName());
			existEvent.setDescription(eventDTO.getDescription());
			existEvent.setEventDate(eventDTO.getEventDate());
			existEvent.setOrganizer(organizer);
			existEvent.setVenue(venue);
			Event event = eventRepository.save(existEvent);
			return MapUtil.toEventDTO(event);
		}).orElseThrow(() -> new ResourceNotFoundException("Event not found with ID: " + id));
	}

	@Transactional
	public String deleteEvent(int id) {
		return eventRepository.findById(id).map(event -> {
			eventRepository.delete(event);
			return "Event deleted Successfully !!";
		}).orElseThrow(() -> new ResourceNotFoundException("Event not found with ID: " + id));
	}

	@Transactional(readOnly = true)
	public List<EventDTO> getEventsByVenue(int venueId) {
		return eventRepository.findByVenueId(venueId).stream().map(MapUtil::toEventDTO).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<EventDTO> getEventsByOrganizer(int organizerId) {
		return eventRepository.findByOrganizerId(organizerId).stream().map(MapUtil::toEventDTO).collect(Collectors.toList());
	}

}
