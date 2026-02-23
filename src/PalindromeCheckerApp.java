import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String org = scan.nextLine().toLowerCase();

        char[] chars = org.toCharArray();

        int left  = 0;
        int right = chars.length - 1;

        boolean isPalindrome = true;

        while (left < right) {
            if (chars[left] != chars[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println("Original : " + org);
        System.out.println("Char Array : " + java.util.Arrays.toString(chars));

        if (isPalindrome) {
            System.out.println("Result : \"" + org + "\" is a Palindrome.");
        } else {
            System.out.println("Result : \"" + org + "\" is NOT a Palindrome.");
        }

        scan.close();
    }

}
