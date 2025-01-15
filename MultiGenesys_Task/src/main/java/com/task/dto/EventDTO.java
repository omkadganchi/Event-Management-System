package com.task.dto;

import java.time.LocalDate;

public class EventDTO {

	private int id;
	private String eventName;
	private LocalDate eventDate;
	private String description;
	private int venueId;
	private int organizerId;
	
	public EventDTO(int id, String eventName, LocalDate eventDate, String description, int venueId, int organizerId) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.description = description;
		this.venueId = venueId;
		this.organizerId = organizerId;
	}

	public EventDTO(String eventName, LocalDate eventDate, String description, int venueId, int organizerId) {
		super();
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.description = description;
		this.venueId = venueId;
		this.organizerId = organizerId;
	}

	public EventDTO(int id, String eventName, LocalDate eventDate, String description, int venueId) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.description = description;
		this.venueId = venueId;
	}

	public EventDTO(String eventName, LocalDate eventDate, String description, int venueId) {
		super();
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.description = description;
		this.venueId = venueId;
	}

	public EventDTO(String eventName, LocalDate eventDate, String description) {
		super();
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.description = description;
	}

	public EventDTO(int id, String eventName, LocalDate eventDate, String description) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.description = description;
	}

	public EventDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getVenueId() {
		return venueId;
	}

	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}

	public int getOrganizerId() {
		return organizerId;
	}

	public void setOrganizerId(int organizerId) {
		this.organizerId = organizerId;
	}

	@Override
	public String toString() {
		return "EventDTO [id=" + id + ", eventName=" + eventName + ", eventDate=" + eventDate + ", description="
				+ description + ", venueId=" + venueId + ", organizerId=" + organizerId + "]";
	}
}
