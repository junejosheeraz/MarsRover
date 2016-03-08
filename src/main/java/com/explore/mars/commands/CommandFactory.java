package com.explore.mars.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.explore.mars.commands.impl.MoveForwardCommand;
import com.explore.mars.commands.impl.TurnLeftCommand;
import com.explore.mars.commands.impl.TurnRightCommand;
import com.explore.mars.exception.InvalidCommandException;

public class CommandFactory {

	private static final Map<CommandOperation, ICommand> commandsMap;
	static {
        commandsMap = new ConcurrentHashMap<CommandOperation, ICommand>();
        commandsMap.put(CommandOperation.F, new MoveForwardCommand());
        commandsMap.put(CommandOperation.R, new TurnRightCommand());
        commandsMap.put(CommandOperation.L, new TurnLeftCommand());
        // Add more here
    };
	
    /**
     * Method to return list of commands to be executed from user input
     * @param userCommands
     * @return
     * @throws InvalidCommandException
     */
	public static List<ICommand> getCommands(String userCommands) throws InvalidCommandException {
		
		if (userCommands == null || userCommands.isEmpty()) 
			return null;
		
		List<ICommand> commandsList = new ArrayList<ICommand>();
		char[] commandChars = userCommands.toCharArray();
		for (char commandChar : commandChars) {
			// Find an operation
			CommandOperation op = getOperationFromChar(commandChar);
			if (op == null) {
				throw new InvalidCommandException("No associated operation found for input ["+commandChar+"], please verify your request and retry");
			}
			ICommand assocCommand = commandsMap.get(op);
			if (assocCommand == null) {
				throw new InvalidCommandException("No associated command found for operation ["+op.toString()+"], please verify your request and retry");
			}
			// Add to the list :)
			commandsList.add(assocCommand);
		}
		
		return commandsList;
	}
	
	/**
	 * This method will take a character and will return appropiate command operation for us to work. If no match is found,
	 * method will return null
	 * 
	 * @param operation
	 * @return
	 */
	private static CommandOperation getOperationFromChar(char operation) {
		if (operation == 'F' || operation == 'f') {
			return CommandOperation.F;
		} else if (operation == 'R' || operation == 'r') {
			return CommandOperation.R;
		} else if (operation == 'L' || operation == 'l') {
			return CommandOperation.L;
		} else {
			return null;
		}
	}
}
