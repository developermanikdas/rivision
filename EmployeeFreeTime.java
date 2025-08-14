import java.util.*;

class Interval {
    public int start;
    public int end;
    public Interval() {}
    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
}

public class EmployeeFreeTime {
    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> allIntervals = new ArrayList<>();

        // Step 1: Flatten all schedules
        for (List<Interval> emp : schedule) {
            allIntervals.addAll(emp);
        }

        // Step 2: Sort by start time
        allIntervals.sort((a, b) -> a.start - b.start);

        // Step 3: Merge intervals
        List<Interval> merged = new ArrayList<>();
        Interval prev = allIntervals.get(0);
        for (int i = 1; i < allIntervals.size(); i++) {
            Interval curr = allIntervals.get(i);
            if (curr.start <= prev.end) {
                prev.end = Math.max(prev.end, curr.end);
            } else {
                merged.add(prev);
                prev = curr;
            }
        }
        merged.add(prev);

        // Step 4: Find gaps (free times)
        List<Interval> freeTimes = new ArrayList<>();
        for (int i = 1; i < merged.size(); i++) {
            freeTimes.add(new Interval(merged.get(i - 1).end, merged.get(i).start));
        }

        return freeTimes;
    }

    public static void main(String[] args) {
        List<List<Interval>> schedule = new ArrayList<>();
        schedule.add(Arrays.asList(new Interval(1, 2), new Interval(5, 6)));
        schedule.add(Arrays.asList(new Interval(1, 3)));
        schedule.add(Arrays.asList(new Interval(4, 10)));

        List<Interval> freeTimes = employeeFreeTime(schedule);
        for (Interval it : freeTimes) {
            System.out.println("[" + it.start + ", " + it.end + "]");
        }
        // Expected: [3,4]
    }
}
