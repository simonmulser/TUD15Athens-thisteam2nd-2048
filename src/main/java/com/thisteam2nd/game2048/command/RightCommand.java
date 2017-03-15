package com.thisteam2nd.game2048.command;

import com.thisteam2nd.game2048.Game;
import com.thisteam2nd.game2048.Logic;
import com.thisteam2nd.game2048.Transformation;

public class RightCommand implements Command {
    public void execute(){
        Integer[][] values = Game.getInstance().getValues();

        values = Transformation.reverse(values);
        values = Logic.moveMerge(values);
        values = Transformation.reverse(values);

        Game.getInstance().setValues(values);
    }
}
