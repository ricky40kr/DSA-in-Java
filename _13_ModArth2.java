// Using Modulo method to find the mod of power 
/*
 * (a+b)%n = (a%n + b%n)%n
 * (a*b)%n = (a%n * b%n)%n
 * (a-b)%n = (a%n - b%n + n)%n
 * (a/b)%n =((a%n)*pow(b,-1)+n)%n
*/

public class _13_ModArth2 {
    public static void main(String[] args) {
        System.out.println(fastPower(397864578, 45678, 100000000));
    }

    static long fastPower(long a, long b, long n) {
        long res = 1;
        while (b > 0) {

            if ((b & 1) != 0) {
                res = (res * a % n) % n; // (res % n = res) since res < n
            }
            a = (a % n * a % n) % n;
            b = b >> 1;

        }
        return res;
    }
}