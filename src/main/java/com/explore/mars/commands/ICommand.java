package com.explore.mars.commands;

import java.util.concurrent.ExecutionException;

import com.explore.mars.data.Grid;
import com.explore.mars.rover.IRobot;

public interface ICommand {

	/**
	 * Method to simulate if we can execute required command before we actually call it. This method make sure that 
	 * implementation should not be able to update anything. Throws exception if operation can not be executed
	 * @param grid
	 * @param robot
	 * @return
	 * @throws ExecutionException
	 */
	boolean simulate(final Grid grid, final IRobot robot) throws ExecutionException;
	
	/**
	 * Method to execute the command on Robot and update Grid and Robot with the new information. Throws exception if 
	 * execution of the command fails
	 * @param grid
	 * @param robot
	 * @return
	 * @throws ExecutionException
	 */
	boolean execute(Grid grid, IRobot robot) throws ExecutionException;
	
}
