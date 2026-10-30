import java.util.Scanner;

public class Main {

    /**
     * Calculates the Nth Tribonacci Number.
     *
     * @param n The index of the Tribonacci number to calculate (0 <= n <= 37).
     * @return The value of T_n.
     */
    public int tribonacci(int n) {
        // Base cases as defined in the problem
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) { // T1 = 1, T2 = 1
            return 1;
        }

        // We will use three variables to keep track of the last three Tribonacci numbers
        // This is a space-optimized dynamic programming approach.
        // t0 will store T_{i-3}
        // t1 will store T_{i-2}
        // t2 will store T_{i-1}
        int t0 = 0; // Corresponds to T_0
        int t1 = 1; // Corresponds to T_1
        int t2 = 1; // Corresponds to T_2

        // Iterate from i = 3 up to n to calculate T_n
        for (int i = 3; i <= n; i++) {
            // Calculate the current Tribonacci number T_i using the recurrence relation
            int nextT = t0 + t1 + t2;

            // Shift the values for the next iteration:
            // The old T_{i-2} (t1) becomes the new T_{i-3} (t0)
            // The old T_{i-1} (t2) becomes the new T_{i-2} (t1)
            // The newly calculated T_i (nextT) becomes the new T_{i-1} (t2)
            t0 = t1;
            t1 = t2;
            t2 = nextT;
        }

        // After the loop, t2 will hold the value of T_n
        return t2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Read the input integer 'n' from standard input
        int n = sc.nextInt();
        sc.close(); // Close the scanner to release system resources

        // Create an instance of Main to call the tribonacci method
        Main solution = new Main();
        // Calculate the Nth Tribonacci number
        int result = solution.tribonacci(n);
        // Print the result to standard output
        System.out.println(result);
    }
}
