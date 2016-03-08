package com.explore.mars;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.explore.mars.commands.ICommand;
import com.explore.mars.commands.impl.mock.MockExceptionCommand;
import com.explore.mars.commands.impl.mock.MockFailureCommand;
import com.explore.mars.commands.impl.mock.MockSuccessCommand;
import com.explore.mars.data.Result;

public class TestRobotController {

	@Test
	public void testRobotControllerWithNoCommands() {
	
		RobotController controller = new RobotController(null, null);
		Result result = controller.execute(null);
		assertEquals(Result.SUCCESS, result);
		
	}
	
	@Test
	public void testRobotControllerWithSuccessCommand() {
		RobotController controller = new RobotController(null, null);
		List<ICommand> commands = new ArrayList<ICommand>();
		commands.add(new MockSuccessCommand());
		Result result = controller.execute(commands);
		assertEquals(Result.SUCCESS, result);
	}
	
	@Test
	public void testRobotControllerWithFailureCommand() {
		RobotController controller = new RobotController(null, null);
		List<ICommand> commands = new ArrayList<ICommand>();
		commands.add(new MockFailureCommand());
		Result result = controller.execute(commands);
		assertEquals(Result.FAILURE, result);
	}
	
	@Test
	public void testRobotControllerWithExceptionCommand() {
		RobotController controller = new RobotController(null, null);
		List<ICommand> commands = new ArrayList<ICommand>();
		commands.add(new MockExceptionCommand());
		Result result = controller.execute(commands);
		assertEquals(Result.FAILURE, result);
	}
}
