// To find numbers of bits to change to convert a to b

import java.util.Scanner;

class _1_bit1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        int b;
        int temp;
        int count = 0;

        System.out.print("Enter number a : ");
        a = sc.nextInt();

        System.out.print("Enter number b : ");
        b = sc.nextInt();

        temp = a ^ b;

        while (temp != 0) {
            if ((temp & 1) == 1) {
                count += 1;
            }
            temp >>= 1;
        }

        System.out.println("Number of bits to change = " + count);

        sc.close();
    }
}