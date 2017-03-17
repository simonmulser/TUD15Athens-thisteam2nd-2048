package com.thisteam2nd.game2048.command;

import com.thisteam2nd.game2048.Game;
import com.thisteam2nd.game2048.Logic;
import com.thisteam2nd.game2048.Transformation;

public class RightCommand implements Command {
    
    Logic logic = new Logic();

    public void execute(){
	logic.setGame(Game.getInstance());
	
        Integer[][] values = Game.getInstance().getValues();

        values = Transformation.reverse(values);
        values = logic.moveMerge(values);
        values = Transformation.reverse(values);

        Game.getInstance().setValues(values);
    }
}
