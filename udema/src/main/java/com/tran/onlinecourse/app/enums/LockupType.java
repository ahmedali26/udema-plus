package com.tran.onlinecourse.app.enums;

public enum LockupType {

		GENDER("GENDER"), CATEGORY("CATEGORY");
	
	private String type;

	private LockupType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
	
	
}
