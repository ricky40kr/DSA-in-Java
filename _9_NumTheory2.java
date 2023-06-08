// Palindrome Numbers

import java.util.Scanner;

public class _9_NumTheory2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        int p;
        int rev = 0;

        System.out.print("Enter a number : ");
        p = sc.nextInt();
        sc.close();

        num = p;
        while (num > 0) {
            rev = (rev * 10) + (num % 10);
            num = num / 10;
        }

        if (p == rev) {
            System.out.println(p + " is a palindrome number.");
        } else {
            System.out.println(p + " is not a palindrome number.");
        }

    }
}
