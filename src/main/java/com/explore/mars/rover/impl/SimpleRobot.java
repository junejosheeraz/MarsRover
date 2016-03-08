package com.explore.mars.rover.impl;

import com.explore.mars.data.Cell;
import com.explore.mars.data.Direction;
import com.explore.mars.rover.IRobot;

/**
 * Simple Implementation for IRobot 
 * @author sjunejo
 *
 */
public class SimpleRobot implements IRobot {

	private Cell currentLocation;
	private Direction currentDirection;
	
	private SimpleRobot(Builder builder) {
		this.currentDirection = builder.currDir;
		this.currentLocation = builder.currLoc;
	}
	
	/**
	 * Builder class for SimpleRobot
	 *
	 */
	public static class Builder {
		private Cell currLoc;
		private Direction currDir;
		
		public Builder currentLocation(Cell cell) {
			this.currLoc = cell;
			return this;
		}
		
		public Builder currentDirection(Direction dir) {
			this.currDir = dir;
			return this;
		}
		
		public SimpleRobot build() {
			return new SimpleRobot(this);
		}
	}
	
	public Cell getCurrentLocation() {
		return this.currentLocation;
	}

	public void setCurrentLocation(Cell currentLocation) {
		this.currentLocation = currentLocation;
	}

	public Direction getCurrentDirection() {
		return currentDirection;
	}

	public void setCurrentDirection(Direction currentDirection) {
		this.currentDirection = currentDirection;
	}

	public String toString() {
		if (currentDirection != null) {
			return currentDirection.getStrRep();
		}
		return "o";
	}
	
}
