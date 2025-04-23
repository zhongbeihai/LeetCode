package com.backtrack;

import java.util.Stack;

public class ConstructSmallestNumberFromDIString_2375 {
    private String ans;
    public String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();

        //created stack to manage decrease operations
        Stack<Integer> stack = new Stack<>();

        //traverse the array till pattern.length() to handle the last sequence
        for(int ind = 0;ind<=pattern.length();ind++){
            // push the number
            stack.push(ind+1);
            if(ind == pattern.length() || pattern.charAt(ind) == 'I'){
                //pattern finds I then append the character in stringbuilder in reverse manner
                while(!stack.isEmpty()){
                    result.append(stack.pop());
                }
            }
        }
        return result.toString();
    }

    public void backtrack(String pattern, int pos, StringBuilder sb){
        // stop condition
        if (sb.length() == pattern.length() + 1){
            if (ans.compareTo(sb.toString()) <0) ans = new String(sb.toString());
            return;
        }

        for (int i = pos; i < pattern.length(); i++){
            for (int j = 1; j <= 9; j++){
                if (pos == 0) {

                    sb.append(j);
                    backtrack(pattern, i + 1, sb);

                    sb.deleteCharAt(sb.length() - 1);
                }
                else {
                    if (pattern.charAt(pos - 1) == 'D' && j < sb.charAt(pos - 1) - '0'){
                        sb.append(j);

                        backtrack(pattern, i + 1, sb);

                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (pattern.charAt(pos - 1) == 'I' && j > sb.charAt(pos - 1) - '0'){
                        sb.append(j);

                        backtrack(pattern, i + 1, sb);

                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        ConstructSmallestNumberFromDIString_2375 c=  new ConstructSmallestNumberFromDIString_2375();
        c.smallestNumber("IIIDIDDD");
    }
}
