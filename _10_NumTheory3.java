// Using Sieve of Eratosthenes method to find all the prime numbers in a given range

import java.util.Arrays;
import java.util.Scanner;

public class _10_NumTheory3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter a number : ");
        n = sc.nextInt();
        sc.close();

        boolean isPrime[] = seiveOfEratosthenes(n);

        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i] == true) {
                System.out.println(i);
            }
        }
    }

    static boolean[] seiveOfEratosthenes(int n) {
        boolean isPrime[] = new boolean[n + 1];

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i] == true) {
                for (int j = 2 * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
