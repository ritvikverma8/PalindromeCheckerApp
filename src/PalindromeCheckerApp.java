import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        int k=1;

        for(int i =0 ; i < input.length()/2 ; i++){
            if(input.charAt(i) != input.charAt((input.length())-i-1)){
                k=-1;
                break;
            }else{
                k=1;
            }
        }
        System.out.println("Input Text : "+input);
        if(k==1){
            System.out.println("Is it a palindrome ? : true ");
        }else{
            System.out.println("Is it a palindrome ? : false ");
        }

    }

}
