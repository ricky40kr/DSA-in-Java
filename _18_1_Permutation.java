// To find the permutation of a string

public class _18_1_Permutation {
    public static void main(String[] args) {
        String s = "abc";
        permute(s, 0, s.length() - 1);
    }

    static void permute(String s, int l, int r) {
        if (l == r) {
            System.out.print(s + "  ");
        }
        for (int i = l; i <= r; i++) {
            s = swap(s, l, i);
            permute(s, l + 1, r);
            s = swap(s, l, i);
        }
    }

    static String swap(String s, int l, int r) {
        char[] charArray = s.toCharArray();
        char temp = charArray[l];
        charArray[l] = charArray[r];
        charArray[r] = temp;

        return String.valueOf(charArray);
    }
}