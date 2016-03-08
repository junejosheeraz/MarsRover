package com.explore.mars.commands.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.explore.mars.commands.ICommand;
import com.explore.mars.data.Cell;
import com.explore.mars.data.Direction;
import com.explore.mars.data.Grid;
import com.explore.mars.exception.ExecutionException;
import com.explore.mars.rover.IRobot;

public class MoveForwardCommand implements ICommand {

	private static final Logger logger = Logger.getLogger(MoveForwardCommand.class.getName());
	
	public boolean simulate(Grid grid, IRobot robot) throws ExecutionException {
		Direction direction = robot.getCurrentDirection();
		Cell oldLocation = robot.getCurrentLocation();
		
		int row = oldLocation.getRow();
		int col = oldLocation.getColum();
		
		if (Direction.NORTH.equals(direction)) {
			row += 1;
		} else if (Direction.SOUTH.equals(direction)) {
			row -= 1;
		} else if(Direction.EAST.equals(direction)) {
			col += 1;
		} else if (Direction.WEST.equals(direction)) { 
			col -= 1;
		}
	
		if (row >=0 && row < grid.getWidth() && col>=0 && col < grid.getHeight()) {
			return true;
		} else {
			logger.log(Level.SEVERE, "No space to move forward!");
			return false;
		}
	}
	
	public boolean execute(Grid grid, IRobot robot) throws ExecutionException {
		Direction direction = robot.getCurrentDirection();
		Cell oldLocation = robot.getCurrentLocation();
		
		int row = oldLocation.getRow();
		int col = oldLocation.getColum();
		
		if (Direction.NORTH.equals(direction)) {
			row += 1;
		} else if (Direction.SOUTH.equals(direction)) {
			row -= 1;
		} else if(Direction.EAST.equals(direction)) {
			col += 1;
		} else if (Direction.WEST.equals(direction)) { 
			col -= 1;
		}
	
		if (row >=0 && row < grid.getWidth() && col>=0 && col < grid.getHeight()) {
			Cell newLocation = grid.getLayout()[row][col];
			robot.setCurrentLocation(newLocation);
			newLocation.placeRobot(robot);
		} else {
			// Can not run
			throw new ExecutionException("No space to move forward!");
		}
		
		// Reset the current location
		oldLocation.setFree();
		return true;
	}
}
