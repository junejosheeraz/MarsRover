package com.explore.mars.commands.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.explore.mars.commands.ICommand;
import com.explore.mars.data.Direction;
import com.explore.mars.rover.IRobot;
import com.explore.mars.rover.impl.SimpleRobot;

public class TestTurnRightCommand {

	@Test
	public void testTurnLeftSimulate() {
		ICommand command = new TurnRightCommand();
		assertTrue(command.simulate(null, null));
	}
	
	@Test
	public void testTurnLeftExecute() {
		ICommand command = new TurnRightCommand();
		IRobot robot = new SimpleRobot.Builder().currentDirection(Direction.EAST).build();
		boolean result = command.execute(null, robot);
		
		// Test EAST -> SOUTH
		assertTrue(result);
		assertEquals(Direction.SOUTH, robot.getCurrentDirection());
		
		// Test SOUTH -> WEST
		result = command.execute(null, robot);
		assertTrue(result);
		assertEquals(Direction.WEST, robot.getCurrentDirection());
		
		// Test WEST -> NORTH
		result = command.execute(null, robot);
		assertTrue(result);
		assertEquals(Direction.NORTH, robot.getCurrentDirection());
		
		// Test NORTH -> EAST 
		result = command.execute(null, robot);
		assertTrue(result);
		assertEquals(Direction.EAST, robot.getCurrentDirection());
	}
	
	
}
