import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    static class PalindromeChecker {

        private String normalize(String input) {
            return input.toLowerCase().replaceAll("[^a-z0-9]", "");
        }

        public boolean checkPalindrome(String input) {
            String org = normalize(input);
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < org.length(); i++) {
                stack.push(org.charAt(i));
            }

            String rev = "";
            while (!stack.isEmpty()) {
                rev += stack.pop();
            }

            return org.equals(rev);
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Input : ");
        String input = scan.nextLine();

        PalindromeChecker checker = new PalindromeChecker();
        boolean result = checker.checkPalindrome(input);

        System.out.println("Is Palindrome : " + result);

        scan.close();
    }
}