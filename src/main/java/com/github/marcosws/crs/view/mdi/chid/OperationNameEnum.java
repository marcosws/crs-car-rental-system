package com.github.marcosws.crs.view.mdi.chid;

public enum OperationNameEnum {
	
	CREATE("CREATE"),
	UPDATE("UPDATE"),
	DELETE("DELETE"),
	READ("READ"),
	CANCEL("CANCEL");
	
	private String name;
	
	OperationNameEnum(String name) {
		this.name = name;
	}
	
	public String getOperationName() {
		return name;
	}
	
}
