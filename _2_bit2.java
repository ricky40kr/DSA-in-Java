// To find set bits (1) in a number

import java.util.Scanner;

public class _2_bit2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        int num;
        int count = 0;

        System.out.print("Enter number a : ");
        a = sc.nextInt();
        num = a;

        while (a != 0) {
            a &= (a - 1); // Used to clear the least significant set bit
            count++; // Ex - 11010 -> least significant set bit is at 2nd pos from last
        }

        System.out.println("Number of set bits in " + num + " = " + count);

        sc.close();
    }
}
