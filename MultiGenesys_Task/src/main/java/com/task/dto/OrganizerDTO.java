package com.task.dto;

public class OrganizerDTO {

	private int id;
    private String name;
    private String contactInfo;
	
    public OrganizerDTO(int id, String name, String contactInfo) {
		super();
		this.id = id;
		this.name = name;
		this.contactInfo = contactInfo;
	}
	
    public OrganizerDTO(String name, String contactInfo) {
		super();
		this.name = name;
		this.contactInfo = contactInfo;
	}
	
    public OrganizerDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "OrganizerDTO [id=" + id + ", name=" + name + ", contactInfo=" + contactInfo + "]";
	}
}
