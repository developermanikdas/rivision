import java.util.*;

public class RandomizedCollection {
    private List<Integer> list;
    private Map<Integer, Set<Integer>> valToIndices;
    private Random rand;

    public RandomizedCollection() {
        list = new ArrayList<>();
        valToIndices = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        boolean isFirstInsert = !valToIndices.containsKey(val);
        valToIndices.putIfAbsent(val, new HashSet<>());
        valToIndices.get(val).add(list.size());
        list.add(val);
        return isFirstInsert;
    }

    public boolean remove(int val) {
        if (!valToIndices.containsKey(val) || valToIndices.get(val).isEmpty())
            return false;

        // Get an index of val to remove
        int indexToRemove = valToIndices.get(val).iterator().next();
        valToIndices.get(val).remove(indexToRemove);

        int lastIndex = list.size() - 1;
        int lastElement = list.get(lastIndex);

        // Swap with last element if not removing the last one
        list.set(indexToRemove, lastElement);
        if (indexToRemove != lastIndex) {
            valToIndices.get(lastElement).remove(lastIndex);
            valToIndices.get(lastElement).add(indexToRemove);
        }

        list.remove(lastIndex);

        // Clean up map if set becomes empty
        if (valToIndices.get(val).isEmpty()) {
            valToIndices.remove(val);
        }

        return true;
    }

    public int getRandom() {
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}
