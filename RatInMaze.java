// Rat in a Maze - I
import java.util.ArrayList;
import java.util.Collections;

class RatInMaze {
    public ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> result = new ArrayList<>();
        if (m[0][0] == 0 || m[n-1][n-1] == 0) return result;

        boolean[][] visited = new boolean[n][n];
        solve(0, 0, m, n, "", visited, result);
        Collections.sort(result);  // Lexicographical order
        return result;
    }

    private void solve(int i, int j, int[][] m, int n, String path, boolean[][] visited, ArrayList<String> result) {
        // If reached destination
        if (i == n - 1 && j == n - 1) {
            result.add(path);
            return;
        }

        // Mark visited
        visited[i][j] = true;

        // Down
        if (isSafe(i + 1, j, m, visited, n)) {
            solve(i + 1, j, m, n, path + "D", visited, result);
        }
        // Left
        if (isSafe(i, j - 1, m, visited, n)) {
            solve(i, j - 1, m, n, path + "L", visited, result);
        }
        // Right
        if (isSafe(i, j + 1, m, visited, n)) {
            solve(i, j + 1, m, n, path + "R", visited, result);
        }
        // Up
        if (isSafe(i - 1, j, m, visited, n)) {
            solve(i - 1, j, m, n, path + "U", visited, result);
        }

        // Backtrack
        visited[i][j] = false;
    }

    private boolean isSafe(int x, int y, int[][] m, boolean[][] visited, int n) {
        return (x >= 0 && y >= 0 && x < n && y < n && m[x][y] == 1 && !visited[x][y]);
    }
}
