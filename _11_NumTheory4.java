// GCD

import java.util.Scanner;

public class _11_NumTheory4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        System.out.print("Enter First Number :");
        a = sc.nextInt();
        System.out.print("Enter Second Number : ");
        b = sc.nextInt();
        sc.close();

        System.out.println("GCD of " + a + " and " + b + " is : " + GCD(a, b));
    }

    public static int GCD(int a, int b) {
        if (b == 0) { // !(a>b)
            return a;
        } else {
            return GCD(b, a % b); // GCD(a-b, b)
        }
    }

}
