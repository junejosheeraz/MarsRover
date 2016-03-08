package com.explore.mars.data;

import com.explore.mars.rover.IRobot;

/**
 * Single Cell in a Grid
 * @author sjunejo
 *
 */
public class Cell {
	
	private int row, colum;
	private IRobot robot;
	
	private Cell(Builder builder) {
		this.row = builder.row;
		this.colum = builder.colum;
	}
	
	/**
	 * Builder for Cell 
	 * 
	 */
	public static class Builder {
		private int row, colum;
		
		public Builder row(int row) {
			this.row = row;
			return this;
		}
		
		public Builder colum(int colum) {
			this.colum = colum;
			return this;
		}
		
		public Cell build() {
			return new Cell(this);
		}
	}
	
	/**
	 * Call this method to place a robot
	 * @param robot
	 */
	public void placeRobot(IRobot robot) {
		this.robot = robot;
	}
	
	/**
	 * Check if cell is already occupied
	 * @return
	 */
	public boolean isOccupied() {
		return robot != null;
	}
	
	/**
	 * Remove the Robot occupation
	 */
	public void setFree() {
		this.robot = null;
	}
	
	/**
	 * Convert cell output to String
	 */
	public String toString() {
		if (robot != null) {
			return robot.toString();
		}
		return "_";
	}

	public int getRow() {
		return row;
	}

	public int getColum() {
		return colum;
	}
}
