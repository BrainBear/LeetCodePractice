package me.brainbear.explore;

public class L344ReverseString {

/*    public String reverseString(String s) {
        if (null == s) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() -1; i >=0; i--){
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }*/

    public String reverseString(String s) {
        if (null == s) {
            return null;
        }

        char[] chars = s.toCharArray();

        int i = 0;
        int j = chars.length - 1;

        while (i < j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;

            i++;
            j--;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        L344ReverseString reverseString = new L344ReverseString();
        System.out.println(reverseString.reverseString("A man, a plan, a canal: Panama"));
    }
}
