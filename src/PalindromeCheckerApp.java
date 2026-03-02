import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeCheckerApp {

    interface PalindromeStrategy {
        boolean checkPalindrome(String input);
    }

    static class StackStrategy implements PalindromeStrategy {
        public boolean checkPalindrome(String input) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < input.length(); i++) {
                stack.push(input.charAt(i));
            }

            String rev = "";
            while (!stack.isEmpty()) {
                rev = rev + stack.pop();
            }

            return input.equals(rev);
        }
    }

    static class DequeStrategy implements PalindromeStrategy {
        public boolean checkPalindrome(String input) {
            Deque<Character> deque = new ArrayDeque<>();

            for (int i = 0; i < input.length(); i++) {
                deque.addLast(input.charAt(i));
            }

            while (deque.size() > 1) {
                if (deque.removeFirst() != deque.removeLast()) {
                    return false;
                }
            }

            return true;
        }
    }

    static class PalindromeChecker {
        private PalindromeStrategy strategy;

        PalindromeChecker(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public boolean check(String input) {
            String org = input.toLowerCase().replaceAll("[^a-z0-9]", "");
            return strategy.checkPalindrome(org);
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a string : ");
        String input = scan.nextLine();

        System.out.print("Choose strategy (1-Stack, 2-Deque) : ");
        int choice = scan.nextInt();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
            System.out.println("Strategy Selected : Stack (LIFO)");
        } else {
            strategy = new DequeStrategy();
            System.out.println("Strategy Selected : Deque (Front & Rear)");
        }

        PalindromeChecker checker = new PalindromeChecker(strategy);
        boolean result = checker.check(input);

        System.out.println("Is Palindrome : " + result);

        scan.close();
    }
}