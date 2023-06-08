import java.util.Stack;

public class _47_ToInfix {
    public static void main(String[] args) {
        String PostFix = "356*6^4/+5-";
        String PreFix = "-+3/^*56645";
        System.out.println("PostToInfix : " + postfixToInfix(PostFix));
        System.out.println("PreToInfix : " + prefixToInfix(PreFix));
    }

    static String postfixToInfix(String s) {
        return convert(s);
    }

    static String prefixToInfix(String s) {
        String rev = reverse(s.toCharArray(), 0, s.length() - 1);
        rev = convert(rev);
        rev = reverse(rev.toCharArray(), 0, rev.length() - 1);

        return rev;
    }

    static String reverse(char str[], int start, int end) {
        char temp;
        while (start < end) {
            temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }

        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') {
                str[i] = ')';
            } else if (str[i] == ')') {
                str[i] = '(';
            }
        }
        return String.valueOf(str);
    }

    static boolean isOperand(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }

    static String convert(String s) {
        Stack<String> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (isOperand(s.charAt(i))) {
                stk.push(s.charAt(i) + "");
            } else {
                String b = stk.pop();
                String a = stk.pop();
                stk.push("(" + a + s.charAt(i) + b + ")");
            }
        }

        return stk.pop();
    }
}
