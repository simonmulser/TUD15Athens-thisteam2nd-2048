package com.thisteam2nd.game2048;


import java.util.LinkedList;

public class Logic {

    public static Integer[] moveLine(Integer[] line){
        LinkedList<Integer> movedLine = new LinkedList<Integer>();
        for(int i = 0; i < line.length; i++){
            if(line[i] > 0){
                movedLine.add(line[i]);
            }
        }
        while(movedLine.size() < 4){
                movedLine.add(0);
        }
        Integer[] movedLineArray = movedLine.toArray(new Integer[4]);
        return movedLineArray;
    }
}
