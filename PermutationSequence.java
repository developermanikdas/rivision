import java.util.*;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;
        
        // Create the initial number list and factorial
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            fact *= i;
        }
        
        // Adjust k to be 0-indexed
        k--;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            fact = fact / (n - i); // remaining (n-1)!
            int index = k / fact;
            result.append(numbers.get(index));
            numbers.remove(index);
            k = k % fact;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        PermutationSequence obj = new PermutationSequence();
        int n = 3, k = 3;
        System.out.println(obj.getPermutation(n, k)); // Output: "213"
    }
}
