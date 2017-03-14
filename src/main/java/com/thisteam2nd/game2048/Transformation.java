package com.thisteam2nd.game2048;

public class Transformation {

    public static Integer[][] transpose(Integer[][] values){
        for(int i = 0; i < values.length; i++){
            for( int j= i + 1; j <values.length; j++){
                int temp = values[i][j];
                values[i][j] = values[j][i];
                values[j][i] = temp;
            }
        }
        return values;
    }

    public static Integer[][] rotate90Degree(Integer[][] values){
        return null;
    }

    public static Integer[][] rotateMinus90Degree(Integer[][] values){
        return null;
    }
}
