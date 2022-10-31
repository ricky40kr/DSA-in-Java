// To find the power of a number
// Always try to use bitwise operators instead of other arithematic operators as bitwise are faster since they work upon bits

public class _12_ModArth1 {
    public static void main(String[] args) {
        System.out.println(fastPower(2, 20));
    }

    static int fastPower(int a, int b) {
        int res = 1;

        while (b > 0) {
            /*
             * if last digit of binary is :-
             * 0 -> the number is even
             * 1-> the number is odd
             */
            if ((b & 1) != 0) { // for even check
                res = res * a;
            }
            a = a * a;
            b = b >> 1;
            /*
             * a/2 = a>>1
             * a*2 = a<<1
             */
        }
        return res;
    }
}
