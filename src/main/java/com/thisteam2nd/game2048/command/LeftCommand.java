package com.thisteam2nd.game2048.command;

import com.thisteam2nd.game2048.Game;
import com.thisteam2nd.game2048.Logic;

public class LeftCommand implements Command {

    public void execute(){
        Integer[][] values = Game.getInstance().getValues();

        values = Logic.moveMerge(values);

        Game.getInstance().setValues(values);

    }
}
