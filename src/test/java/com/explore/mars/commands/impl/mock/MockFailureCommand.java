package com.explore.mars.commands.impl.mock;

import com.explore.mars.commands.ICommand;
import com.explore.mars.data.Grid;
import com.explore.mars.exception.ExecutionException;
import com.explore.mars.rover.IRobot;

public class MockFailureCommand implements ICommand{

	@Override
	public boolean simulate(final Grid grid, final IRobot robot) throws ExecutionException {
		return false;
	}
	
	@Override
	public boolean execute(final Grid grid, final IRobot robot) throws ExecutionException {
		return false;
	}
	
	
}
