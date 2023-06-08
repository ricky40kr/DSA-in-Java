// To find the only non-repeating elements in an array where every element
// repeats twice
// n ^ n = 0
// n ^ 0 = n

public class _3_bit3 {
    public static void main(String[] args) {
        int arr[] = { 1, 5, 4, 1, 2, 4, 5 };
        int num = 0;

        for (int i = 0; i < arr.length; i++) {
            num ^= arr[i];
        }

        System.out.println("The only non-repeating number = " + num);
    }
}
