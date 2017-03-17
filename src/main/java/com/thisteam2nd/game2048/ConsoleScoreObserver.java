package com.thisteam2nd.game2048;

public class ConsoleScoreObserver implements GameObserver {

    public void update() {
	System.out.println("In the console your score is: " + Game.getInstance().getScore());
    }

}
