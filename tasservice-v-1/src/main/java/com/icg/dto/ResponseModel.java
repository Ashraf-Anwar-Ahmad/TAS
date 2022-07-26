package com.icg.dto;

import com.fasterxml.jackson.databind.JsonNode;

public class ResponseModel {

	private boolean status;
	private String message;
	private String fileId;
	private JsonNode object;

	public ResponseModel() {
	}

	public ResponseModel(boolean status, String message, String fileId) {
		this.status = status;
		this.message = message;
		this.fileId=fileId;
	}
	public ResponseModel(boolean status, String message, JsonNode object ) {
		this.status = status;
		this.message = message;
		this.object = object;
	}

	public boolean getStatus() {
		return status;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public JsonNode getObject() {
		return object;
	}

	public void setObject(JsonNode object) {
		this.object = object;
	}

}
