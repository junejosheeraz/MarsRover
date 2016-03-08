package com.explore.mars;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.explore.mars.commands.ICommand;
import com.explore.mars.data.Grid;
import com.explore.mars.data.Result;
import com.explore.mars.exception.ExecutionException;
import com.explore.mars.rover.IRobot;

/**
 * Class responsible for accepting and executing commands on Robot
 * 
 * <p>
 * Assumption: Robot will move until resources permit and will fail fast if any of the command fails without retracting
 * </p> 
 * 
 * 
 * @author sjunejo
 *
 */
public class RobotController {

	private static final Logger logger = Logger.getLogger(RobotController.class.getName());
	private Grid grid;
	private IRobot robot;
	
	public RobotController(Grid grid, IRobot robot) {
		this.grid = grid;
		this.robot = robot;
	}
	
	
	/**
	 * Method which will be executing the commands in sequential 
	 * @param commands
	 * @return
	 */
	public Result execute(List<ICommand> commands) {
		
		Result result = Result.SUCCESS;
		if (commands != null) {
			for (ICommand command : commands) {
				try {
					if (command.simulate(grid, robot)) {
						command.execute(grid, robot);
					} else {
						// Which means we can not perform this operation at this time, so break and leave
						result = Result.FAILURE;
						break;
					}
				} catch (ExecutionException ee) {
					logger.log(Level.SEVERE, "Failed to execute command", ee);
					result = Result.FAILURE;
					break;
				}
			}
		}
		return result;
	}
}
