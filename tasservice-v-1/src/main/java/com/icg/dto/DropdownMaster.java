package com.icg.dto;

public class DropdownMaster {

	public String id;
	public String name;
	public String desc;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "DropdownMaster [id=" + id + ", name=" + name + ", desc=" + desc + "]";
	}
	
	
	
}
