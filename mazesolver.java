public class mazesolver {

	private int beginrow = 0;
	private int begincol = 0;
	private int endrow = 5;
	private int endcol = 10;

	public int[][] grid =  {{ 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1 },
							{ 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1 },
							{ 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1 },
							{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
							{ 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1 },
							{ 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1 },
							{ 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1 },
							{ 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1 }};
	// 1's are the ones where one can travel, 0's are holes
	// player starts from (0,0)

	public void printmaze() {
		//simply prinitng the maze
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public boolean findpath(int row, int collumn) {
		//in this method recursing over all possible directions after a given square
		boolean done = false;
		if (valid(row, collumn)) {
			grid[row][collumn] = 9; //visited
			if (row == endrow && collumn == endcol)
				done = true;
			else {
				done = (findpath(row, collumn+1));
				if (!done)
					done = findpath(row+1, collumn);
				if (!done)
					done = findpath(row, collumn - 1);
				if (!done)
					done = findpath(row - 1, collumn);
			}
			if (done)
				grid[row][collumn] = 7;
		}
		return done;
	}

	public boolean valid(int row, int collumn) {
		// in this method checking if the current point is within the maze and whether it is 1
		if (row < grid.length && row >= 0 && collumn >= 0
				&& collumn < grid[0].length)
			if (grid[row][collumn] == 1)
				return true;
			else
				return false;
		else
			return false;
	}

}
