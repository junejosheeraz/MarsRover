package com.explore.mars.data;

public enum Direction {

	NORTH("^"), SOUTH("v"), EAST(">"), WEST("<");
	
	private String strRep;
	
	private Direction(String strRep) {
		this.strRep = strRep;
	}
	
	public String getStrRep() {
		return this.strRep;
	}
}
