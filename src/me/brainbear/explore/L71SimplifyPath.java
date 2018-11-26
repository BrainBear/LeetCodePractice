package me.brainbear.explore;

import java.util.Stack;

public class L71SimplifyPath {

    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : split) {
            if (s.isEmpty() || s.equals(".")) {
                continue;
            }

            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(s);
        }

        StringBuilder sb = new StringBuilder();

        for (String s : stack) {
            sb.append('/');
            sb.append(s);
        }
        return stack.isEmpty() ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        L71SimplifyPath simplifyPath = new L71SimplifyPath();

        System.out.println(simplifyPath.simplifyPath("/home/"));
        System.out.println(simplifyPath.simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath.simplifyPath("/"));
        System.out.println(simplifyPath.simplifyPath("/.."));
    }
}
