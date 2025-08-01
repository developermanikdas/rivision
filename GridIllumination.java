import java.util.*;

public class GridIllumination {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Set<String> lampSet = new HashSet<>();
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        Map<Integer, Integer> diagMap = new HashMap<>();
        Map<Integer, Integer> antiDiagMap = new HashMap<>();

        // Add all lamps to sets and update maps
        for (int[] lamp : lamps) {
            int r = lamp[0], c = lamp[1];
            String key = r + "," + c;
            if (lampSet.contains(key)) continue;

            lampSet.add(key);
            rowMap.put(r, rowMap.getOrDefault(r, 0) + 1);
            colMap.put(c, colMap.getOrDefault(c, 0) + 1);
            diagMap.put(r - c, diagMap.getOrDefault(r - c, 0) + 1);
            antiDiagMap.put(r + c, antiDiagMap.getOrDefault(r + c, 0) + 1);
        }

        int[][] directions = {
            {0, 0}, {0, 1}, {1, 0}, {-1, 0}, {0, -1},
            {1, 1}, {-1, -1}, {1, -1}, {-1, 1}
        };

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int r = queries[i][0], c = queries[i][1];

            // Check illumination
            if (rowMap.getOrDefault(r, 0) > 0 ||
                colMap.getOrDefault(c, 0) > 0 ||
                diagMap.getOrDefault(r - c, 0) > 0 ||
                antiDiagMap.getOrDefault(r + c, 0) > 0) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }

            // Turn off lamps in 3x3 grid around (r, c)
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                String key = nr + "," + nc;

                if (lampSet.contains(key)) {
                    lampSet.remove(key);

                    rowMap.put(nr, rowMap.get(nr) - 1);
                    if (rowMap.get(nr) == 0) rowMap.remove(nr);

                    colMap.put(nc, colMap.get(nc) - 1);
                    if (colMap.get(nc) == 0) colMap.remove(nc);

                    diagMap.put(nr - nc, diagMap.get(nr - nc) - 1);
                    if (diagMap.get(nr - nc) == 0) diagMap.remove(nr - nc);

                    antiDiagMap.put(nr + nc, antiDiagMap.get(nr + nc) - 1);
                    if (antiDiagMap.get(nr + nc) == 0) antiDiagMap.remove(nr + nc);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        GridIllumination gi = new GridIllumination();
        int[][] lamps = {{0,0}, {1,0}};
        int[][] queries = {{1,1}, {1,0}};
        int[] res = gi.gridIllumination(5, lamps, queries);
        System.out.println(Arrays.toString(res)); // Output: [1, 0]
    }
}
