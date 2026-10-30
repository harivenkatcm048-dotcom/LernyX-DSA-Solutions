import java.util.Scanner;
import java.util.Arrays; // Not strictly necessary for this logic, but good for context

public class Main {

    /**
     * Determines if every element at index i (0 < i < N-1) is NOT strictly greater than
     * both its immediate left and right neighbors.
     *
     * Note: The problem description "strictly less than or equal to both"
     * seems to be in conflict with the provided example outputs.
     * This implementation matches the example outputs, implying the condition is
     * effectively: `nums[i] <= nums[i-1] || nums[i] <= nums[i+1]` for all middle elements.
     *
     * @param nums The input array of integers.
     * @return true if the condition holds for all middle elements, false otherwise.
     */
    public static boolean checkLocalMinimums(int[] nums) {
        int N = nums.length;

        // If the array has less than 3 elements, there are no "middle" elements
        // (i.e., no elements at index i where 0 < i < N-1).
        // In this case, the condition is vacuously true because there are no elements
        // to violate the condition.
        if (N < 3) {
            return true;
        }

        // Iterate through the array, checking only the "middle" elements.
        // The loop starts at index 1 (the first element that has a left neighbor)
        // and ends at N-2 (the last element that has a right neighbor).
        for (int i = 1; i < N - 1; i++) {
            // This condition checks if nums[i] is strictly greater than *both* its neighbors.
            // If it is, then it violates the implicit rule derived from the examples,
            // which seems to be: "nums[i] is NOT a strict local maximum".
            // i.e., it must be (nums[i] <= nums[i-1] OR nums[i] <= nums[i+1]).
            // The negation of this (a violation) is (nums[i] > nums[i-1] AND nums[i] > nums[i+1]).
            if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
                // As soon as we find one violation, we can immediately return false.
                return false;
            }
        }

        // If the loop completes, it means we have checked all relevant middle elements
        // and found no violations. Therefore, the condition holds true.
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the entire line as a string, e.g., "[10, 5, 2, 5, 100]"
        String line = sc.nextLine();
        sc.close(); // Close scanner after reading the line

        int[] nums;

        // Handle the case of an empty array input "[]"
        if (line.equals("[]")) {
            nums = new int[0];
        } else {
            // Remove the leading '[' and trailing ']' characters
            String numbersString = line.substring(1, line.length() - 1);

            // If the string is now empty (e.g., original was "[]"), then it's an empty array
            if (numbersString.isEmpty()) {
                nums = new int[0];
            } else {
                // Split the string by ", " to get individual number strings
                String[] numStrings = numbersString.split(", ");

                nums = new int[numStrings.length];
                for (int i = 0; i < numStrings.length; i++) {
                    // Parse each string to an integer
                    nums[i] = Integer.parseInt(numStrings[i].trim());
                }
            }
        }

        // Call the function and print the result
        System.out.println(checkLocalMinimums(nums));
    }
}
