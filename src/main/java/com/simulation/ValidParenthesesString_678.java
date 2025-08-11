package com.simulation;

public class ValidParenthesesString_678 {
    public boolean checkValidString(String s) {
        // count maximum and minimum unopened parentheses
        int low = 0, high = 0;
        char[] ss = s.toCharArray();
        for (char c: ss){
            if (c == '('){
                low++;
                high++;
            } else if (c == ')') {
                low--;
                high--;
            } else if (c == '*') {
                low--;
                high++;
            }
            if (high < 0) return false; // too many '('
            if (low < 0) low = 0;
        }

        return low == 0;
    }
}
