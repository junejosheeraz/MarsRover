package com.explore.mars.commands.impl;

import com.explore.mars.commands.ICommand;
import com.explore.mars.data.Direction;
import com.explore.mars.data.Grid;
import com.explore.mars.exception.ExecutionException;
import com.explore.mars.rover.IRobot;

/**
 * Command to perform operation 'R' on a robot in grid
 * 
 * @author sjunejo
 *
 */
public class TurnRightCommand implements ICommand {

	public boolean execute(Grid grid, IRobot robot) throws ExecutionException {
		Direction direction = robot.getCurrentDirection();
		if (Direction.NORTH.equals(direction)) {
			robot.setCurrentDirection(Direction.EAST);
		} else if (Direction.SOUTH.equals(direction)) {
			robot.setCurrentDirection(Direction.WEST);
		} else if(Direction.EAST.equals(direction)) {
			robot.setCurrentDirection(Direction.SOUTH);
		} else if (Direction.WEST.equals(direction)) { 
			robot.setCurrentDirection(Direction.NORTH);
		}
		return true;
	}
	
	
	public boolean simulate(Grid grid, IRobot robot) throws ExecutionException {
		// We should always be able to turn direction
		return true;
	}
}
