import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);


        System.out.print("Enter a string: ");
        String org = scan.nextLine();


        String rev = "";

        for (int i = org.length() - 1; i >= 0; i--) {
            rev = rev + org.charAt(i);
        }


        System.out.println("Original : " + org);
        System.out.println("Reversed : " + rev);

        if (org.equalsIgnoreCase(rev)) {
            System.out.println("Result   : \"" + org + "\" is a Palindrome.");
        } else {
            System.out.println("Result   : \"" + org + "\" is NOT a Palindrome.");
        }

        scan.close();

    }

}
