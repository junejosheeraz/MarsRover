package com.explore.mars.utils.print;

import com.explore.mars.data.Grid;

public class MarsPrinter {

	/**
	 * Method which will simply return String representation of a Grid
	 * @param grid
	 * @return
	 */
	public static String print(Grid grid) {
		StringBuilder sb = new StringBuilder("Current grid view:\n");
		
		// We have to print upside down to strat with height
		for (int i = grid.getWidth() - 1; i >= 0; i--) {
			for (int j = 0; j < grid.getHeight()  ; j++) {
				sb.append(" ").append(grid.getLayout()[i][j].toString());
			}
			sb.append("\n");
		}
		sb.append("\n");
		return sb.toString();
	}
}
