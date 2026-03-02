import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeCheckerApp {

    static String normalize(String input) {
        return input.toLowerCase().replaceAll("[^a-z0-9]", "");
    }

    static boolean twoPointer(String org) {
        char[] chars = org.toCharArray();
        int left  = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (chars[left] != chars[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    static boolean stackMethod(String org) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < org.length(); i++) {
            stack.push(org.charAt(i));
        }

        String rev = "";
        while (!stack.isEmpty()) {
            rev = rev + stack.pop();
        }

        return org.equals(rev);
    }

    static boolean dequeMethod(String org) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < org.length(); i++) {
            deque.addLast(org.charAt(i));
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }

    static boolean recursiveMethod(String org, int left, int right) {
        if (left >= right) return true;
        if (org.charAt(left) != org.charAt(right)) return false;
        return recursiveMethod(org, left + 1, right - 1);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Input : ");
        String input = scan.nextLine();
        String org   = normalize(input);

        System.out.println("\n Performance Comparison \n");

        long start, end;
        boolean result;

        start  = System.nanoTime();
        result = twoPointer(org);
        end    = System.nanoTime();
        System.out.println("Two-Pointer");
        System.out.println("Is Palindrome  : " + result);
        System.out.println("Execution time : " + (end - start) + " ns\n");

        start  = System.nanoTime();
        result = stackMethod(org);
        end    = System.nanoTime();
        System.out.println("Stack");
        System.out.println("Is Palindrome  : " + result);
        System.out.println("Execution time : " + (end - start) + " ns\n");

        start  = System.nanoTime();
        result = dequeMethod(org);
        end    = System.nanoTime();
        System.out.println("Deque");
        System.out.println("Is Palindrome  : " + result);
        System.out.println("Execution time : " + (end - start) + " ns\n");

        start  = System.nanoTime();
        result = recursiveMethod(org, 0, org.length() - 1);
        end    = System.nanoTime();
        System.out.println("Recursive");
        System.out.println("Is Palindrome  : " + result);
        System.out.println("Execution time : " + (end - start) + " ns");

        scan.close();
    }
}