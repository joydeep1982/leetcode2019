package com.practice.ds.array;

public class NumberOfIslands {
	
	public static void main(String[] args) {
		NumberOfIslands o = new NumberOfIslands();
		char[][] island = new char[][] {
			{'1','1','0','0','0'},
			{'1','1','0','0','0'},
			{'0','0','1','0','0'},
			{'0','0','0','1','1'}
		};
		int count = o.numIslands(island);
		System.out.println(count);
	}
	
	public int numIslands(char[][] grid) {
        boolean[][] discovered = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for  (int  j = 0; j < grid[i].length; j++) {
                if (!discovered[i][j] && grid[i][j] == '1') {
                    count++;
                    discover(grid, discovered, i, j);
                }
            }
        }
        
        return count;
    }
    
    public void discover(char[][] grid, boolean[][] discovered, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return;
        }
        if (discovered[i][j]) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        discovered[i][j] = true;
        discover(grid, discovered, i + 1, j);
        discover(grid, discovered, i - 1, j);
        discover(grid, discovered, i, j + 1);
        discover(grid, discovered, i, j - 1);
    }

}
