package com.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.task.dao.OrganizerRepository;
import com.task.dto.OrganizerDTO;
import com.task.entity.Organizer;
import com.task.exception.ResourceNotFoundException;
import com.task.util.MapUtil;

@Service
public class OrganizerService {

	@Autowired
	OrganizerRepository organizerRepository;

	@Transactional
	public OrganizerDTO createOrganizer(OrganizerDTO organizerDTO) {
		Organizer organizer = MapUtil.toOrganizerEntity(organizerDTO);
		organizer = organizerRepository.save(organizer);
		return MapUtil.toOrganizerDTO(organizer);
	}

	@Transactional(readOnly = true)
	public OrganizerDTO getOrganizerById(int id) {
		return organizerRepository.findById(id).map(MapUtil::toOrganizerDTO)
				.orElseThrow(() -> new ResourceNotFoundException("Organizer not found with ID: " + id));
	}

	@Transactional
	public OrganizerDTO updateOrganizer(int id, OrganizerDTO organizerDTO) {
		return organizerRepository.findById(id).map(existorganizer -> {
			existorganizer.setName(organizerDTO.getName());
			existorganizer.setContactInfo(organizerDTO.getContactInfo());
			return MapUtil.toOrganizerDTO(organizerRepository.save(existorganizer));
		}).orElseThrow(() -> new ResourceNotFoundException("Organizer not found with ID: " + id));
	}

	@Transactional
	public String deleteOrganizer(int id) {
		return organizerRepository.findById(id).map(Organizer -> {
			organizerRepository.delete(Organizer);
			return "Organizer deleted successfully !!";
		}).orElseThrow(() -> new ResourceNotFoundException("Organizer not found with ID: " + id));
	}

}
