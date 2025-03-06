import java.util.Scanner;

public class Palindrom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String str = sc.nextLine();

        if(isPalindrome(str))
        {
            System.out.println("Palindrom");
        }else{
            System.out.println("Not Palindrom");
        }
    }

    public static boolean isPalindrome(String str) 
    {
        if (str.length() == 0 || str.length() == 1) 
        {
            return true;
        }
        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalindrome(str.substring(1, str.length() - 1));
        }
        else {
                return false;
            }
            
    }          


}