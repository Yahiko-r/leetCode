package other;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        int length = tokens.length;
        String  s = tokens[0];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<length;i++) {
            s = tokens[i];
            int operand1 = stack.pop();
            int operand2 = stack.pop();
            if (s.equals("+"))
                stack.push(operand1 + operand2);
            else if (s.equals("-"))
                stack.push(operand2 - operand1);
            else if (s.equals("*")) {
                stack.push(operand1 * operand2);
            } else if (s.equals("/"))
                stack.push(operand2 / operand1);
            else
                stack.push(Integer.parseInt(s));
        }

        return stack.pop();

    }
    public static void main(String[] args) {
        EvaluateReversePolishNotation e=new EvaluateReversePolishNotation();
        String[] tokens={"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int i = e.evalRPN(tokens);
        System.out.println( i);
    }
}
