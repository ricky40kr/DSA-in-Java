// Swapping two numbers without using third variable

public class _4_bit4 {
    public static void main(String[] args) {
        int a = 5;
        int b = 6;
        System.out.println("Before Swapping :");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        // Swapping
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("After Swapping :");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

    }
}
