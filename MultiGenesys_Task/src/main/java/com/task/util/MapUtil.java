package com.task.util;

import com.task.dto.EventDTO;
import com.task.dto.VenueDTO;
import com.task.dto.OrganizerDTO;
import com.task.entity.Event;
import com.task.entity.Venue;
import com.task.entity.Organizer;

public class MapUtil {
    
    public static EventDTO toEventDTO(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setEventName(event.getEventName());
        eventDTO.setEventDate(event.getEventDate());
        eventDTO.setDescription(event.getDescription());
        eventDTO.setVenueId(event.getVenue().getId());
        eventDTO.setOrganizerId(event.getOrganizer().getId());
        return eventDTO;
    }

    public static VenueDTO toVenueDTO(Venue venue) {
        VenueDTO venueDTO = new VenueDTO();
        venueDTO.setId(venue.getId());
        venueDTO.setName(venue.getName());
        venueDTO.setLocation(venue.getLocation());
        venueDTO.setCapacity(venue.getCapacity());
        return venueDTO;
    }

    public static OrganizerDTO toOrganizerDTO(Organizer organizer) {
        OrganizerDTO organizerDTO = new OrganizerDTO();
        organizerDTO.setId(organizer.getId());
        organizerDTO.setName(organizer.getName());
        organizerDTO.setContactInfo(organizer.getContactInfo());
        return organizerDTO;
    }

    public static Event toEventEntity(EventDTO eventDTO, Venue venue, Organizer organizer) {
        Event event = new Event();
        event.setEventName(eventDTO.getEventName());
        event.setEventDate(eventDTO.getEventDate());
        event.setDescription(eventDTO.getDescription());
        event.setVenue(venue);
        event.setOrganizer(organizer);
        return event;
    }

    public static Venue toVenueEntity(VenueDTO venueDTO) {
        Venue venue = new Venue();
        venue.setName(venueDTO.getName());
        venue.setLocation(venueDTO.getLocation());
        venue.setCapacity(venueDTO.getCapacity());
        return venue;
    }

    public static Organizer toOrganizerEntity(OrganizerDTO organizerDTO) {
        Organizer organizer = new Organizer();
        organizer.setName(organizerDTO.getName());
        organizer.setContactInfo(organizerDTO.getContactInfo());
        return organizer;
    }
}
