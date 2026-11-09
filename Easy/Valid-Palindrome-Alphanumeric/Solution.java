import java.util.Scanner;

public class Main {

    /**
     * Determines if a string is a palindrome, considering only alphanumeric characters
     * and ignoring cases.
     *
     * @param s The input string.
     * @return "true" if the string is a palindrome, "false" otherwise.
     */
    public static String isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "true"; // Empty string is a valid palindrome
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Move left pointer past non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Move right pointer past non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // If pointers have crossed or met, we've checked all relevant characters
            if (left >= right) {
                break;
            }

            // Compare alphanumeric characters, ignoring case
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return "false"; // Mismatch found
            }

            // Move pointers inwards
            left++;
            right--;
        }

        return "true"; // All alphanumeric characters matched
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine(); // Read the entire line as input
        System.out.println(isPalindrome(s));
        sc.close(); // Close the scanner to prevent resource leaks
    }
}
