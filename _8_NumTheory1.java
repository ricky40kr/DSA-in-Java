// number of trailing zeros in a factorial

import java.util.Scanner;

public class _8_NumTheory1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int res = 0;

        System.out.print("Enter a number to find its factorial :");
        n = sc.nextInt();

        for (int i = 5; i <= n; i = i * 5) {
            res += n / i;
        }

        System.out.println("Number of zeroes in " + n + " : " + res);
        sc.close();
    }
}
