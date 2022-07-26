package com.icg.dto;

import java.io.File;

public class Upload {

	private String uploadType;
	private String fileName;
	private File doc;
	public String getUploadType() {
		return uploadType;
	}
	public void setUploadType(String uploadType) {
		this.uploadType = uploadType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public File getDoc() {
		return doc;
	}
	public void setDoc(File doc) {
		this.doc = doc;
	}
	@Override
	public String toString() {
		return "Upload [uploadType=" + uploadType + ", fileName=" + fileName + ", doc=" + doc + "]";
	}
	
	
	
}
