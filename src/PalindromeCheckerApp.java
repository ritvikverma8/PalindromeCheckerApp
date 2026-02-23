import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class PalindromeCheckerApp {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String org = scan.nextLine().toLowerCase();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < org.length(); i++) {
            queue.add(org.charAt(i));
            stack.push(org.charAt(i));
        }

        boolean isPalindrome = true;

        while (!queue.isEmpty() && !stack.isEmpty()) {
            char fromQueue = queue.remove();
            char fromStack = stack.pop();
            if (fromQueue != fromStack) {
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
