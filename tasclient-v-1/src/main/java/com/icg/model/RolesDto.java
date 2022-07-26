package com.icg.model;

public class RolesDto {

	public String value;
	public String role;
	public boolean selected;
	
	
	public RolesDto() {
		super();
	}
	
	public RolesDto(String value, String role, boolean selected) {
		super();
		this.value = value;
		this.role = role;
		this.selected = selected;
	}
	
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	@Override
	public String toString() {
		return "RolesDto [value=" + value + ", role=" + role + ", selected=" + selected + "]";
	}
	
	
}
