package com.thisteam2nd.game2048;

import org.apache.commons.lang.ArrayUtils;

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

    public static Integer[][] reverse(Integer[][] values){
        for (int i = 0; i < values.length; i++){
            ArrayUtils.reverse(values[i]);
        }
        return values;
    }

    public static Integer[][] rotate90(Integer[][] values){
        return reverse(transpose(values));
    }
}
