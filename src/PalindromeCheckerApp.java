import java.util.Scanner;

public class PalindromeCheckerApp {

    static boolean checkPalindrome(String org, int left, int right) {
        if (left >= right) {
            return true;
        }

        if (org.charAt(left) != org.charAt(right)) {
            return false;
        }

        return checkPalindrome(org, left + 1, right - 1);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String org = scan.nextLine().toLowerCase();


        boolean isPalindrome = checkPalindrome(org, 0, org.length() - 1);

        System.out.println();

        if (isPalindrome) {
            System.out.println("Result : \"" + org + "\" is a Palindrome.");
        } else {
            System.out.println("Result : \"" + org + "\" is NOT a Palindrome.");
        }

        scan.close();
    }

}
