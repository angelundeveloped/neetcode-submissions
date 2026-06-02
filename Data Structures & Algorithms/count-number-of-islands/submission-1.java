// import java.util.HashSet;
 

class Solution {
    private static final int[][] directions = {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };

    public int numIslands(char[][] grid) {

        //get dimensions of the grid
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int islands = 0; // count of islands

        // iterate through the rows and columsn
        for (int r = 0; r < rowLen; r++) {
            for (int c = 0; c < colLen; c++) {
                if (grid[r][c] == '1') { // If we find dirt
                    breathFirstSearch(grid, r, c); // we run breath first search
                    islands++; // add to the island count
                }
            }
        }
        return islands; // return the count
    }

    private void breathFirstSearch(char[][] grid, int r, int c) {
        // we create a queue for a linkedlist
        Queue<int[]> q = new LinkedList<>();
        grid[r][c] = '0'; // we asign 0 to the current cell
        q.add(new int[]{r, c});

        while(!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0], col = node[1];

            for (int[] dir : directions) {
                int nr = row + dir[0], nc = col + dir[1];
                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1') {
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = '0';
                }
            }
        }
    }
}
