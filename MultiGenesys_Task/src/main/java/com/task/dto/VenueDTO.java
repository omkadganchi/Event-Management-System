package com.task.dto;

public class VenueDTO {
   
	private int id;
    private String name;
    private String location;
    private int capacity;
	
    public VenueDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VenueDTO(int id, String name, String location, int capacity) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.capacity = capacity;
	}
	public VenueDTO(String name, String location, int capacity) {
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
	@Override
	public String toString() {
		return "VenueDTO [id=" + id + ", name=" + name + ", location=" + location + ", capacity=" + capacity + "]";
	}
}
