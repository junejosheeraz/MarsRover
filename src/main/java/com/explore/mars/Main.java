package com.explore.mars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.explore.mars.commands.CommandFactory;
import com.explore.mars.commands.ICommand;
import com.explore.mars.data.Direction;
import com.explore.mars.data.Grid;
import com.explore.mars.data.Result;
import com.explore.mars.data.RoverArguments;
import com.explore.mars.exception.InvalidCommandException;
import com.explore.mars.rover.IRobot;
import com.explore.mars.rover.impl.SimpleRobot;
import com.explore.mars.utils.argument.IArgumetParser;
import com.explore.mars.utils.argument.SimpleArgumentParser;
import com.explore.mars.utils.print.MarsPrinter;

/**
 * Main class which will be giving interface to user for interaction
 * 
 * 
 * @author sjunejo
 *
 */
public class Main {

	private static final Logger logger = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) {
		
		// We should move this Factory
		IArgumetParser parser = new SimpleArgumentParser();
		RoverArguments roverArgs = parser.parse(args);
		
		// Now initialize Grid
		Grid grid = new Grid.Builder().width(roverArgs.getWidth()).height(roverArgs.getHeight()).build();
		
		// Robot starting with 0,0 facing NORTH
		IRobot robot = new SimpleRobot.Builder().currentLocation(grid.getLayout()[0][0]).currentDirection(Direction.NORTH).build();
		grid.getLayout()[0][0].placeRobot(robot);
		
		// Initialize controller for commands
		RobotController controller = new RobotController(grid, robot);
	
		// print the default grid view
		System.out.println("Mars Rover Exploration");
		System.out.println("======================");
		System.out.println(MarsPrinter.print(grid));
		
		// Input from user
		String curLine = ""; 
		InputStreamReader converter = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(converter);
		while (true) {
			System.out.println("Enter command for Rover to move (Example: RFLFFRF, X to exit) ? ");
			try {
				curLine = in.readLine();
			}catch (IOException ioe) {
				System.out.println("Unable to handle the input, try again please!\n");
			}
			
			// Check if user want to exit
			if (curLine.equalsIgnoreCase("x")) {
				System.out.println("\nProgram terminated!");
				break;
			}
			
			// Fulfil the request 
			if (curLine != null && !curLine.isEmpty()) {
				List<ICommand> commands = null;
				try {
					commands = CommandFactory.getCommands(curLine);
					
					// Execute the commands via controller
					Result result = controller.execute(commands);
					
					// Respond to user with the result
					if (Result.FAILURE.equals(result)) {
						logger.log(Level.SEVERE, "Failed to execute command, see logs for more details\n");
					} else {
						logger.log(Level.INFO, "Command executed successfully!\n");
					}
				} catch (InvalidCommandException ice) {
					logger.log(Level.SEVERE, "Invalid command recieved, " + ice.getMessage());
				}
			} else {
				logger.info("No commands provided...");
			}
			
			// Reprint the Grid with the new view
			System.out.println(MarsPrinter.print(grid));
		}	
		
	}
}
