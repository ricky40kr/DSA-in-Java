// To find the factorial of large numbers using BigInteger

import java.math.BigInteger;

public class _19_BigInt {
    public static void main(String[] args) {
        int a = 100;
        System.out.println(factorial(a));

        // To Compare two BigIntegers
        BigInteger b = new BigInteger("50");
        BigInteger c = new BigInteger("500");

        if (b.compareTo(c) == 0) {
            System.out.println("b and c are equal");
        } else {
            System.out.println("b and c are not equal");
        }
    }

    static BigInteger factorial(int a) {
        BigInteger n = BigInteger.ONE;
        BigInteger factz = BigInteger.valueOf(a);
        if (a == 0 || a == 1) {
            return n;
        }
        return factz.multiply(factorial(a - 1));
    }
}
