// Infix to Postfix conversion

import java.util.Stack;

public class _46_ToPostAndPreFix {
    public static void main(String[] args) {
        String infix = "3+(5*6)^6/4-5";
        System.out.println("Infix : " + infix);
        System.out.println("Postfix : " + infixToPostfix(infix));
        System.out.println("Prefix : " + infixToPrefix(infix));
    }

    // Infix to PreFix
    static String infixToPrefix(String s) {
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

    static String infixToPostfix(String s) {
        return convert(s);
    }

    static int precedence(char c) {
        if (c == '^')
            return 3;
        else if (c == '/' || c == '*')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return 0;
    }

    static boolean isOperand(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }

    // infix to Postfix
    static String convert(String exp) {
        String postFix = new String("");
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (isOperand(c))
                postFix += c;
            else if (c == '(')
                st.push(c);
            else if (c == ')') {
                while (st.peek() != '(') {
                    postFix += st.pop();
                }
                st.pop();
            } else {
                while (!st.isEmpty() && precedence(c) <= precedence(st.peek())) {
                    postFix += st.pop();
                }
                st.push(c);
            }

        }

        while (!st.isEmpty()) {
            postFix += st.pop();
        }

        return postFix;
    }
}