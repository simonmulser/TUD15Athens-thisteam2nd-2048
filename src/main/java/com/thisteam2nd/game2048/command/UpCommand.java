package com.thisteam2nd.game2048.command;

import com.thisteam2nd.game2048.Game;
import com.thisteam2nd.game2048.Logic;
import com.thisteam2nd.game2048.Transformation;

public class UpCommand implements Command {
    
    Logic logic = new Logic();

    public void execute(){
	logic.setGame(Game.getInstance());
	
        Integer[][] values = Game.getInstance().getValues();

        values = Transformation.rotate90(Transformation.rotate90(Transformation.rotate90(values)));
        values = logic.moveMerge(values);
        values = Transformation.rotate90(values);

        Game.getInstance().setValues(values);
    }
}
