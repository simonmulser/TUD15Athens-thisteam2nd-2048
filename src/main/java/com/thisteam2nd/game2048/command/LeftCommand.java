package com.thisteam2nd.game2048.command;

import com.thisteam2nd.game2048.Game;
import com.thisteam2nd.game2048.Logic;

public class LeftCommand implements Command {
    
    Logic logic = new Logic();

    public void execute(){
	logic.setGame(Game.getInstance());
	
        Integer[][] values = Game.getInstance().getValues();

        values = logic.moveMerge(values);

        Game.getInstance().setValues(values);

    }
}
