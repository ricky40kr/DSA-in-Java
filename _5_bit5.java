// To find the given position bit.

public class _5_bit5 {
    public static void main(String[] args) {
        int n = 14;
        int pos = 3;

        int bitMask = 1 << (pos - 1);

        if ((n & bitMask) == 0) {
            System.out.println("The bit at postion " + pos + " is 0.");
        } else {
            System.out.println("The bit at postion " + pos + " is 1.");
        }
    }
}
