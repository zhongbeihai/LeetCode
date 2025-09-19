package com.systemdesign;

import java.util.HashMap;

public class Spreadsheet {
    HashMap<Integer, HashMap<Integer, Integer>> sheet = new HashMap<>();
    public Spreadsheet(int rows) {
        for (int i = 0; i < 26; i++){
            sheet.put(i, new HashMap<>());
        }
    }

    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        if (col < 0 || col >= 26) return;
        int row = Integer.parseInt(cell.substring(1));
        sheet.get(col).put(row, value);
    }

    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        if (col < 0 || col >= 26) return;
        int row = Integer.parseInt(cell.substring(1));
        sheet.get(col).put(row, 0);
    }

    public int getValue(String formula) {
        String withoutEqu = formula.substring(1);
        String[] parts = withoutEqu.split("\\+");

        int left = 0;
        if (Character.isLetter(parts[0].charAt(0))){
            int col = parts[0].charAt(0) - 'A';
            if (col >= 0 && col < 26) {
                int row = Integer.parseInt(parts[0].substring(1));
                if (sheet.get(col).get(row) != null) left = sheet.get(col).get(row);
            }
        }else {
            left = Integer.parseInt(parts[0]);
        }

        int right = 0;
        if (Character.isLetter(parts[1].charAt(0))){
            int col = parts[1].charAt(0) - 'A';
            if (col >= 0 && col < 26) {
                int row = Integer.parseInt(parts[1].substring(1));
                if (sheet.get(col).get(row) != null) right = sheet.get(col).get(row);
            }
        }else {
            right = Integer.parseInt(parts[1]);
        }

        return left + right;
    }

    public static void main(String[] args) {
        Spreadsheet s = new Spreadsheet(456);
        s.getValue("=O126+10272");
    }
}
