package me.brainbear.explore;

import java.util.Stack;

public class L20IsValid {
    public boolean isValid(String s) {

        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.isEmpty() || !stack.pop().equals('(')){
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty() || !stack.pop().equals('[')){
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty() || !stack.pop().equals('{')){
                        return false;
                    }
                    break;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        L20IsValid isValid = new L20IsValid();


        System.out.println(isValid.isValid("()"));
        System.out.println(isValid.isValid("()[]{}"));
        System.out.println(isValid.isValid("([)]"));
        System.out.println(isValid.isValid("{[]}"));
        System.out.println(isValid.isValid("]"));

    }
}
