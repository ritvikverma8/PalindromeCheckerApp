import java.util.Scanner;

public class PalindromeCheckerApp {

    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node buildList(String org) {
        Node head = null;
        Node tail = null;

        for (int i = 0; i < org.length(); i++) {
            Node newNode = new Node(org.charAt(i));

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail      = newNode;
            }
        }
        return head;
    }

    static Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node reverseList(Node head) {
        Node prev    = null;
        Node current = head;

        while (current != null) {
            Node nextNode  = current.next;
            current.next   = prev;
            prev           = current;
            current        = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String org = scan.nextLine().toLowerCase();

        Node head = buildList(org);

        Node middle      = findMiddle(head);
        Node secondHalf  = reverseList(middle);
        Node secondCopy  = secondHalf;


        Node first  = head;
        Node second = secondHalf;

        boolean isPalindrome = true;

        while (second != null) {
            if (first.data != second.data) {
                isPalindrome = false;
            }
            first  = first.next;
            second = second.next;
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
