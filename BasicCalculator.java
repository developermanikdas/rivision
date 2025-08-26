import java.util.*;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;   // current result
        int sign = 1;  // current sign
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int num = 0;
                // handle multi-digit numbers
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--; // adjust index after loop
                res += sign * num;
            } 
            else if (c == '+') {
                sign = 1;
            } 
            else if (c == '-') {
                sign = -1;
            } 
            else if (c == '(') {
                stack.push(res);   // save previous result
                stack.push(sign);  // save sign
                res = 0;           // reset result
                sign = 1;          // reset sign
            } 
            else if (c == ')') {
                int prevSign = stack.pop();
                int prevRes = stack.pop();
                res = prevRes + prevSign * res;
            }
            // ignore spaces
        }

        return res;
    }

    // Test
    public static void main(String[] args) {
        BasicCalculator calc = new BasicCalculator();
        System.out.println(calc.calculate("1 + 1"));             // 2
        System.out.println(calc.calculate(" 2-1 + 2 "));         // 3
        System.out.println(calc.calculate("(1+(4+5+2)-3)+(6+8)"));// 23
    }
}
