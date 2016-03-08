package com.explore.mars.rover;

import com.explore.mars.data.Cell;
import com.explore.mars.data.Direction;

public interface IRobot {
	
	/**
	 * Retrieve current cell in a Grid
	 * @return
	 */
	Cell getCurrentLocation();
	
	/**
	 * Set the current cell information
	 * @param currentLocation
	 */
	void setCurrentLocation(Cell currentLocation);
	
	/**
	 * Get the current direction of the Robot
	 * @return
	 */
	Direction getCurrentDirection();
	
	/**
	 * Set the current direction of the robot
	 * @param direction
	 */
	void setCurrentDirection(Direction direction);
	
	
}
