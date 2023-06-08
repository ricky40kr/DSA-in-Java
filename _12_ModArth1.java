// To find the power of a number
// Always try to use bitwise operators instead of other arithematic operators as bitwise are faster since they work upon bits

public class _12_ModArth1 {
    public static void main(String[] args) {
        System.out.println(fastPower(-2, 5));
    }

    static double fastPower(double x, int n) {
        int sign = ((n & 0) != 0 && x < 0) ? -1 : 1;
        if (sign == -1)
            x *= -1;

        if (n == 0)
            return 1;

        double res = 1;

        while (n > 0) {
            /*
             * if last digit of binary is :-
             * 0 -> the number is even
             * 1-> the number is odd
             */
            if ((n & 1) != 0) { // for even check (b%2)==0
                res *= x;
            }

            x *= x;
            n >>= 1;
            /*
             * a/2 = a>>1
             * a*2 = a<<1
             */
        }

        return res * sign;
    }
}
