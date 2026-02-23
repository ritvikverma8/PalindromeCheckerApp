import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeCheckerApp {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String org = scan.nextLine().toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < org.length(); i++) {
            deque.addLast(org.charAt(i));
        }

        boolean isPalindrome = true;

        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear  = deque.removeLast();

            if (front != rear) {
                isPalindrome = false;
            }
        }

        System.out.println();

        if (isPalindrome) {
            System.out.println("Result : \"" + org + "\" is a Palindrome.");
        } else {
            System.out.println("Result : \"" + org + "\" is NOT a Palindrome.");
        }

        scan.close();
    }

}
