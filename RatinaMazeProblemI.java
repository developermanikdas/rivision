import java.util.*;

public class RatinaMazeProblemI {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        
        if (m[0][0] == 1) {
            solve(0, 0, m, n, "", visited, result);
        }
        
        Collections.sort(result); // Lexicographical order
        return result;
    }

    static void solve(int i, int j, int[][] m, int n, String path,
                      boolean[][] visited, ArrayList<String> result) {
        // Base condition: reach destination
        if (i == n - 1 && j == n - 1) {
            result.add(path);
            return;
        }

        // Mark current cell visited
        visited[i][j] = true;

        // Move Down
        if (isSafe(i + 1, j, m, visited, n)) {
            solve(i + 1, j, m, n, path + 'D', visited, result);
        }

        // Move Left
        if (isSafe(i, j - 1, m, visited, n)) {
            solve(i, j - 1, m, n, path + 'L', visited, result);
        }

        // Move Right
        if (isSafe(i, j + 1, m, visited, n)) {
            solve(i, j + 1, m, n, path + 'R', visited, result);
        }

        // Move Up
        if (isSafe(i - 1, j, m, visited, n)) {
            solve(i - 1, j, m, n, path + 'U', visited, result);
        }

        // Backtrack
        visited[i][j] = false;
    }

    static boolean isSafe(int x, int y, int[][] m, boolean[][] visited, int n) {
        return (x >= 0 && x < n && y >= 0 && y < n && !visited[x][y] && m[x][y] == 1);
    }

    // Driver code
    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };

        ArrayList<String> paths = findPath(maze, maze.length);
        System.out.println("All possible paths: " + paths);
    }
}
