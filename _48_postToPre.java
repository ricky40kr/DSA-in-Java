import java.util.Stack;

public class _48_postToPre {
    public static void main(String[] args) {
        String PostFix = "356*6^4/+5-";

        System.out.println("Postfix : " + PostFix);
        System.out.println("Prefix : " + postfixToPrefix(PostFix));
    }

    static String postfixToPrefix(String s) {
        Stack<String> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (isOperand(s.charAt(i))) {
                stk.push(s.charAt(i) + "");
            } else {
                String b = stk.pop();
                String a = stk.pop();
                stk.push(s.charAt(i) + a + b);
            }
        }

        return stk.pop();
    }

    static boolean isOperand(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }
}
