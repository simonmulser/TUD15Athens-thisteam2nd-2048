package com.thisteam2nd.game2048.command;

import com.thisteam2nd.game2048.Game;
import com.thisteam2nd.game2048.Logic;
import com.thisteam2nd.game2048.Transformation;

public class UpCommand implements Command {
    public void execute(){
        Integer[][] values = Game.getInstance().getValues();

        values = Transformation.rotate90(Transformation.rotate90(Transformation.rotate90(values)));
        values = Logic.moveMerge(values);
        values = Transformation.rotate90(values);

        Game.getInstance().setValues(values);
    }
}
