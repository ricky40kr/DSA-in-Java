// To find the power set of a string

public class _17_PowerSet {
    public static void main(String[] args) {
        String s = "abcd";
        powerSet(s, 0, "");
    }

    static void powerSet(String s, int i, String curr) {
        if (i == s.length()) {
            System.out.print("[" + curr + "]  ");
            return;
        }
        powerSet(s, i + 1, curr);
        powerSet(s, i + 1, curr + s.charAt(i));
    }
}