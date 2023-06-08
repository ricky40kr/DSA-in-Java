// To find the number of ways in n*m matrix

public class _14_Recur {
    public static void main(String[] args) {
        System.out.println(matrixWays(3, 4));
    }

    static int matrixWays(int n, int m) {
        if (n == 1 || m == 1) {
            return 1;
        }
        return matrixWays(n - 1, m) + matrixWays(n, m - 1);
    }
}
