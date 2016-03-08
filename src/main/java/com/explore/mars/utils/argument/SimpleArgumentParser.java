package com.explore.mars.utils.argument;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.explore.mars.data.MarsConstants;
import com.explore.mars.data.RoverArguments;

/**
 * Simple argument parser which will always assume first value Width and second value as Height of Grid
 * 
 * @author sjunejo
 *
 */

public class SimpleArgumentParser implements IArgumetParser {
	
	private final static Logger logger = Logger.getLogger(SimpleArgumentParser.class.getName());
	
	public RoverArguments parse(String[] args) {
		RoverArguments arguments = new RoverArguments();
		
		// Start with 0 and 0
		int _width = 0, _height = 0;
		if (args != null && args.length != 0) {
			try {
				_width = Integer.valueOf(args[0]);
			} catch (NumberFormatException nfe) {
				// Invalid number, use default
				logger.log(Level.SEVERE, "Provided Grid width value is invalid, initialzing grid with default Width=" + MarsConstants.GRID_DEFAULT_WIDTH);
				_width = MarsConstants.GRID_DEFAULT_WIDTH;
			}
			
			// Just to protect ArrayIndexOfBoundException
			if (args.length > 1) {
				try {
					_height = Integer.valueOf(args[1]);
				} catch (NumberFormatException nfe) {
					// Invalid number, use default
					logger.log(Level.SEVERE, "Provided Grid width value is invalid, initialzing grid with default Height=" + MarsConstants.GRID_DEFAULT_HEIGHT);
					_height = MarsConstants.GRID_DEFAULT_HEIGHT;
				}
			}
			
		} else {
			// Just use default
			_width = MarsConstants.GRID_DEFAULT_WIDTH;
			_height = MarsConstants.GRID_DEFAULT_HEIGHT;
		}
		
		// Set the resolved values and return
		arguments.setWidth(_width);
		arguments.setHeight(_height);
		
		return arguments;
	}

}
