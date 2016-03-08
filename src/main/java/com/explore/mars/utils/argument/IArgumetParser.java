package com.explore.mars.utils.argument;

import com.explore.mars.data.RoverArguments;

public interface IArgumetParser {

	/**
	 * Parse the argument passed to the program and return a well formed object so that we can easily use
	 * @param args
	 * @return
	 */
	RoverArguments parse(String[] args);
	
}
