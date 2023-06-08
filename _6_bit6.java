// To set bit of given position in a number

public class _6_bit6 {
    public static void main(String[] args) {
        int n = 14;
        int pos = 1;

        int bitMask = 1 << (pos - 1);

        System.out.println("Before Set Bit at position " + pos + " : " + n);

        n = n | bitMask;
        System.out.println("After Set Bit at position " + pos + " : " + n);

    }
}
