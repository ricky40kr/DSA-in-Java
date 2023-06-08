public class _16_Palindrome {
    public static void main(String[] args) {
        String s = "abcbad";
        if (palindrome(s, 0, s.length() - 1)) {
            System.out.println("It is a palindrome!");
        } else {
            System.out.println("It is not a palindrome!");
        }
    }

    static boolean palindrome(String s, int i, int j) {
        if (i >= j) {
            return true;
        }
        if (s.charAt(i) != s.charAt(j)) {
            return false;
        }
        return palindrome(s, i + 1, j - 1);
    }
}
