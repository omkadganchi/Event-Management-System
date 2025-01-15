package com.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.task.dao.VenueRepository;
import com.task.dto.VenueDTO;
import com.task.entity.Venue;
import com.task.exception.ResourceNotFoundException;
import com.task.util.MapUtil;

@Service
public class VenueService {

	@Autowired
	VenueRepository venueRepository;

	@Transactional
	public VenueDTO createOrganizer(VenueDTO venueDTO) {
		Venue venue = MapUtil.toVenueEntity(venueDTO);
		venue = venueRepository.save(venue);
		return MapUtil.toVenueDTO(venue);
	}

	@Transactional(readOnly = true)
	public VenueDTO getVenueById(int id) {
		return venueRepository.findById(id).map(MapUtil::toVenueDTO)
				.orElseThrow(() -> new ResourceNotFoundException("Venue not found with ID: " + id));
	}

	@Transactional
	public VenueDTO updateVenue(int id, VenueDTO venueDTO) {
		return venueRepository.findById(id).map(existVenue -> {
			existVenue.setName(venueDTO.getName());
			existVenue.setLocation(venueDTO.getLocation());
			existVenue.setCapacity(venueDTO.getCapacity());
			return MapUtil.toVenueDTO(venueRepository.save(existVenue));
		}).orElseThrow(() -> new ResourceNotFoundException("Venue not found with ID: " + id));
	}

	@Transactional
	public String deleteVenue(int id) {
		return venueRepository.findById(id).map(venue -> {
			venueRepository.delete(venue);
			return "Venue deleted successfully !!";
		}).orElseThrow(() -> new ResourceNotFoundException("Venue not found with ID: " + id));
	}

}
