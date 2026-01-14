//package com.dequeue_and_priorityqueue;
//
//
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//
//public class ReorderDataInLogFiles {
//    public String[] reorderLogFiles(String[] logs) {
//        ArrayList<Pair<String, String>> l = new ArrayList<>();
//        for(String log: logs){
//            String[] s = log.split(" ", 2);
//            l.add(new Pair<>(s[0], s[1]));
//        }
//        l.sort(new Comparator<Pair<String, String>>() {
//            @Override
//            public int compare(Pair<String, String> o1, Pair<String, String> o2) {
//                int vs = o1.getValue().compareTo(o2.getValue());
//
//                if(containsDigit(o1.getValue()) && containsDigit(o2.getValue())){
//                    return 0;
//                }else if ( (!containsDigit(o1.getValue()) && containsDigit(o2.getValue())) ||
//                        containsDigit(o1.getValue()) && !containsDigit(o2.getValue())) {
//                    return -vs;
//                }else if (vs == 0){
//                    return o1.getKey().compareTo(o2.getKey());
//                }else {
//                    return vs;
//                }
//            }
//        });
//
//        for(int i = 0; i < logs.length; i++){
//            logs[i] = l.get(i).getKey() + " " + l.get(i).getValue();
//        }
//
//        return logs;
//    }
//
//    public  boolean containsDigit(String str) {
//        // 遍历字符串中的每一个字符
//        for (char c : str.toCharArray()) {
//            // 检查当前字符是否是数字
//            if (Character.isDigit(c)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//
//        String[] s = {"mo", "m w"};
//        Arrays.sort(s);
//        System.out.println("mo".compareTo("m w"));
//
//        System.out.println(Arrays.toString(s));
//
//        ReorderDataInLogFiles r = new ReorderDataInLogFiles();
//        r.reorderLogFiles(new String[]{"5 m w","j mo","t q h","g 07","o 2 0"});
//    }
//}
