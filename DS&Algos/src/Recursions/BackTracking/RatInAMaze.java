package Recursions.BackTracking;

/* Given a n*n matrix, with:
1. 0 marked cell as blocked,
2. 1 marked cell as valid cell,
3. 1st(0,0) being the start
4. Last(n,n) being the end
we need to find, a path from start to end with all 1s, if there exists*/
public class RatInAMaze {
    public static void main(String[] args) {
        int[][] maze = {{1, 1, 0}, {0, 1, 0}, {0, 1, 1}};
        RatInMaze(maze, 3);
    }

    /*n: Matrix size*/
    public static void RatInMaze(int[][] maze, int n) {
        int[][] pathVisitedMatrix = new int[maze.length][maze.length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                pathVisitedMatrix[i][j] = 0;
            }
        }
        // Matrix.displayMatrix(pathVisitedMatrix);
        //TraverseMaze(maze, 0, 0, pathVisitedMatrix);
        SolveMaze_PrintAllPaths(maze, 0, 0, pathVisitedMatrix);
    }

    public static void SolveMaze(int[][] maze, int i, int j, int[][] pathVisitedMatrix) {
        // System.out.println(String.format("Visited (%d, %d)", i, j));
        if (i < 0 || j < 0 || i > maze.length - 1 || j > maze.length - 1 || pathVisitedMatrix[i][j] == 1 || maze[i][j] == 0) {
            return;
        }

        pathVisitedMatrix[i][j] = 1;

        if (i == maze.length - 1 && j == maze.length - 1) System.out.println(true);

        // Traverse Top
        SolveMaze(maze, i - 1, j, pathVisitedMatrix);

        // Traverse Right
        SolveMaze(maze, i, j + 1, pathVisitedMatrix);

        // Traverse Down
        SolveMaze(maze, i + 1, j, pathVisitedMatrix);

        // Traverse Left
        SolveMaze(maze, i, j - 1, pathVisitedMatrix);
    }

    public static void SolveMaze_PrintAllPaths(int[][] maze, int i, int j, int[][] pathVisitedMatrix) {
        // System.out.println(String.format("Visited (%d, %d)", i, j));
        if (i < 0 || j < 0 || i >= maze.length || j >= maze.length || pathVisitedMatrix[i][j] == 1 || maze[i][j] == 0)
            return;

        // Mark current element in path matrix to Visited
        pathVisitedMatrix[i][j] = 1;

        // Check if we've reached the end
        if (i == maze.length - 1 && j == maze.length - 1) {
            for (int r = 0; r < maze.length; r++) {
                for (int c = 0; c < maze.length; c++) {
                    System.out.print(pathVisitedMatrix[r][c] + " ");
                    /*String end = (r == maze.length - 1 && c == maze.length - 1) ? "END" : " -> ";
                    if (pathVisitedMatrix[r][c] != 0) System.out.print(String.format("(%d, %d) %s ", r, c, end));*/
                }
                System.out.println();
            }
            System.out.println();

            // Reset current element in path matrix to un-visited, as it can be part of some other path
            pathVisitedMatrix[i][j] = 0;

            return;
        }

        // Traverse Top
        SolveMaze_PrintAllPaths(maze, i - 1, j, pathVisitedMatrix);

        // Traverse Right
        SolveMaze_PrintAllPaths(maze, i, j + 1, pathVisitedMatrix);

        // Traverse Down
        SolveMaze_PrintAllPaths(maze, i + 1, j, pathVisitedMatrix);

        // Traverse Left
        SolveMaze_PrintAllPaths(maze, i, j - 1, pathVisitedMatrix);

        pathVisitedMatrix[i][j] = 0;
    }
}
