// package sum of digits;

import java.util.Scanner;

class SumDigit{

    static int sumOfDigit(int num)
    {
        if(num==0) 
          return 0;
        else 
        return num%10 + sumOfDigit(num/10);

    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Number: ");
        int num = sc.nextInt();
        System.out.println(sumOfDigit(num));
    }
}
