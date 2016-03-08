package com.explore.mars.data;

/**
 * Grid class which lays foundation for Rover to move
 * 
 * @author sjunejo
 *
 */
public class Grid {

	// Grid layout data
	private Cell[][] layout;
	
	// Actual Width and Height
	private int width, height;
	
	/**
	 * Builder for initializing Grid
	 *
	 */
	public static class Builder {
		private int width;
		private int height;
		
		public Builder(){}
		
		public Builder width(int width) {
			this.width = width;
			return this;
		}
		
		public Builder height(int height) {
			this.height = height;
			return this;
		}
		
		/**
		 * If Width and Height provided are invalid, Grid will be inittialized with default, we can through exception if required
		 * @return
		 * @throws Inva
		 */
		public Grid build() {
			width = width > MarsConstants.GRID_MIN_WIDTH && width <= MarsConstants.GRID_MAX_WIDTH ? width : MarsConstants.GRID_DEFAULT_WIDTH;
			height = height > MarsConstants.GRID_MIN_HEIGHT && height <= MarsConstants.GRID_MAX_HEIGHT ? height :  MarsConstants.GRID_DEFAULT_HEIGHT;
			return new Grid(this);
		}
	}
	
	/**
	 * Force them to use Builder
	 */
	private Grid(Builder builder) {
		this.width = builder.width;
		this.height = builder.height; 
		
		// populate the grid layout
		layout = new Cell[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				layout[i][j] = new Cell.Builder().row(i).colum(j).build();
			}
		}
	}

	public Cell[][] getLayout() {
		return layout;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}
 