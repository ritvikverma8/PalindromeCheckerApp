import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String org = scan.nextLine().toLowerCase();

        Stack<Character> stack = new Stack<>();

        for (char c : org.toCharArray()) {
            stack.push(c);
        }

        String rev = "";

        while (!stack.isEmpty()) {
            rev = rev + stack.pop();
        }

        System.out.println("Original : " + org);
        System.out.println("Reversed : " + rev);

        if (org.equals(rev)) {
            System.out.println("Result   : \"" + org + "\" is a Palindrome.");
        } else {
            System.out.println("Result   : \"" + org + "\" is NOT a Palindrome.");
        }

        scan.close();
    }

}
