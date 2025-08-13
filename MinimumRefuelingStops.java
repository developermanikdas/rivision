import java.util.PriorityQueue;

public class MinimumRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // Max-heap to store fuel from passed stations
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int fuel = startFuel;
        int prevPos = 0;
        int stops = 0;

        // Add target as a "final station" with 0 fuel
        int[][] allStations = new int[stations.length + 1][2];
        for (int i = 0; i < stations.length; i++) {
            allStations[i] = stations[i];
        }
        allStations[stations.length] = new int[]{target, 0};

        for (int[] station : allStations) {
            int pos = station[0];
            int fuelHere = station[1];

            // Travel from previous position to current station
            fuel -= (pos - prevPos);

            // If we run out of fuel, refuel from best past stations
            while (fuel < 0 && !maxHeap.isEmpty()) {
                fuel += maxHeap.poll();
                stops++;
            }

            // If still can't reach this station, return -1
            if (fuel < 0) return -1;

            // Store current station's fuel for possible future use
            maxHeap.offer(fuelHere);

            prevPos = pos;
        }

        return stops;
    }

    public static void main(String[] args) {
        MinimumRefuelingStops obj = new MinimumRefuelingStops();
        int target = 100;
        int startFuel = 10;
        int[][] stations = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        System.out.println(obj.minRefuelStops(target, startFuel, stations));
    }
}
