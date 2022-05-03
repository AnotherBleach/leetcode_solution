package com.another.leetcode.simulation;

import java.util.Arrays;

public class ReorderedLog {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(new ReorderedLog().reorderLogFiles(new String[]{
                "a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"
        })));
    }
    class Element {
        int index;
        String data;

        public Element(String data, int index) {
            this.data = data;
            this.index = index;
        }
    }

    public String[] reorderLogFiles(String[] logs) {
        Element[] arrays = new Element[logs.length];
        for (int i = 0; i < logs.length; i++) {
            arrays[i] = new Element(logs[i], i);
        }
        Arrays.sort(arrays, (x1, x2) -> {

            boolean digit_x1 = isDigit(x1);
            boolean digit_x2 = isDigit(x2);
            if (digit_x1 && digit_x2) {
                return x1.index - x2.index;
            }

            if (digit_x1) {
                return 1;
            }
            if (digit_x2) {
                return -1;
            }

            int index_x1 = x1.data.indexOf(" ");
            int index_x2 = x2.data.indexOf(" ");

            int result= x1.data.substring(index_x1 + 1).compareTo(x2.data.substring(index_x2 + 1));

            if(result!=0)return result;

            return x1.data.substring(0,index_x1).compareTo(x2.data.substring(0,index_x2));
        });

        for (int i = 0; i < logs.length; i++) {
            logs[i] = arrays[i].data;
        }
        return logs;
    }

    private boolean isDigit(Element x1) {
        char last = x1.data.charAt(x1.data.length() - 1);
        return last >= '0' && last <= '9';
    }
}
