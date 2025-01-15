package com.task.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Organizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String contactInfo;

    @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Event> events;

    public Organizer() {
        super();
    }

	public Organizer(int id, String name, String contactInfo, List<Event> events) {
		super();
		this.id = id;
		this.name = name;
		this.contactInfo = contactInfo;
		this.events = events;
	}

	public Organizer(String name, String contactInfo, List<Event> events) {
		super();
		this.name = name;
		this.contactInfo = contactInfo;
		this.events = events;
	}

	public Organizer(int id, String name, String contactInfo) {
		super();
		this.id = id;
		this.name = name;
		this.contactInfo = contactInfo;
	}

	public Organizer(String name, String contactInfo) {
		super();
		this.name = name;
		this.contactInfo = contactInfo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Organizer [id=" + id + ", name=" + name + ", contactInfo=" + contactInfo + ", events=" + events + "]";
	}
}
