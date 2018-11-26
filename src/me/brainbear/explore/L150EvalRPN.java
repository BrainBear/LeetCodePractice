package me.brainbear.explore;

import java.util.Stack;

public class L150EvalRPN {

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String s : tokens) {
            stack.push(s);
        }
        return getValue(stack);
    }

    private int getValue(Stack<String> stack) {
        String pop = stack.pop();
        int temp1;
        int temp2;
        switch (pop) {
            case "+":
                return getValue(stack) + getValue(stack);
            case "-":
                temp1 = getValue(stack);
                temp2 = getValue(stack);
                return temp2 - temp1;
            case "*":
                return getValue(stack) * getValue(stack);
            case "/":
                 temp1 = getValue(stack);
                 temp2 = getValue(stack);
                return temp2 / temp1;
            default:
                return Integer.valueOf(pop);
        }
    }


    public static void main(String[] args) {
        L150EvalRPN evalRPN = new L150EvalRPN();

        System.out.println(evalRPN.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(evalRPN.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(evalRPN.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
        System.out.println(evalRPN.evalRPN(new String[]{"4", "3", "-"}));
    }
}
