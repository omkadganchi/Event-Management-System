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
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String location;
    private int capacity;

    @OneToMany(mappedBy = "venue", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Event> event; 

    public Venue() {
        super();
    }

	public Venue(int id, String name, String location, int capacity, List<Event> event) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.capacity = capacity;
		this.event = event;
	}

	public Venue(String name, String location, int capacity, List<Event> event) {
		super();
		this.name = name;
		this.location = location;
		this.capacity = capacity;
		this.event = event;
	}

	public Venue(String name, String location, int capacity) {
		super();
		this.name = name;
		this.location = location;
		this.capacity = capacity;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Event> getEvent() {
		return event;
	}

	public void setEvent(List<Event> event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Venue [id=" + id + ", name=" + name + ", location=" + location + ", capacity=" + capacity + ", event="
				+ event + "]";
	}
}
