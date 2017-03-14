package com.thisteam2nd.game2048;


import java.util.LinkedList;

public class Logic {

    public static Integer[] moveLine(Integer[] line) {
        LinkedList<Integer> movedLine = new LinkedList<Integer>();
        for (int i = 0; i < line.length; i++) {
            if (line[i] > 0) {
                movedLine.add(line[i]);
            }
        }
        while (movedLine.size() < 4) {
            movedLine.add(0);
        }

        return movedLine.toArray(new Integer[4]);
    }

    public static Integer[] mergeLine(Integer[] line) {
        LinkedList<Integer> mergedLine = new LinkedList<Integer>();
        int i = 0;
        while(i <= 3){
            if(i < 3 && line[i].equals(line[i + 1])){
                mergedLine.add(line[i] * 2);
                i++;
            } else {
                mergedLine.add(line[i]);
            }
            i++;
        }

        while (mergedLine.size() < 4) {
            mergedLine.add(0);
        }
        return mergedLine.toArray(new Integer[4]);
    }

    public static boolean isGameOver(Integer[][] board){
        return true;
    }
}
