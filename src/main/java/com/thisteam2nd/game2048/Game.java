package com.thisteam2nd.game2048;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Game implements KeyListener{

    private volatile static Game instance;

    private JFrame frame;
    private GameBoard board;

    private Integer[][] values = new Integer[][]{
	{0, 0, 0, 0},
	{0, 0, 0, 0},
	{0, 0, 0, 0},
	{0, 0, 0, 0}
    };

    private Game() {
	frame = new JFrame();
	board = new GameBoard();
	frame.add(board);
	board.addKeyListener(this);

	frame.setTitle("this team second - 2048");
	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	frame.setVisible(true);
	frame.setResizable(false);
	frame.setSize(655,685);
	addRandomValue();
	addRandomValue();
    }

    public static Game getInstance() {
	if (instance == null) {
	    synchronized (Game.class) {
		if (instance == null) {
		    instance = new Game();
		}
	    }
	}
	return instance;
    }

    public void keyPressed(KeyEvent ev) {
	int keyCode =  ev.getKeyCode();
	if (keyCode == KeyEvent.VK_LEFT) {
	    magic();
	} else if (keyCode == KeyEvent.VK_RIGHT) {
	    values = Transformation.reverse(values);
	    magic();
	    values = Transformation.reverse(values);
	} else if (keyCode == KeyEvent.VK_UP) {
	    values = Transformation.rotate90(Transformation.rotate90(Transformation.rotate90(values)));
	    magic();
	    values = Transformation.rotate90(values);
	} else if (keyCode == KeyEvent.VK_DOWN) {
	    values = Transformation.rotate90(values);
	    magic();
	    values = Transformation.rotate90(Transformation.rotate90(Transformation.rotate90(values)));
	}
	addRandomValue();
	board.repaint();
    }

    private void magic() {
	for(int i = 0; i < 4; i++){
	    values[i] = Logic.mergeLine(Logic.moveLine(values[i]));
	}
    }

    public void addRandomValue() {
	int column, row;
	int number;

	do{
	    column = (int)(Math.random() * 4);
	    row = (int)(Math.random() * 4);
	} while(values[column][row] != 0);

	if ((int)(Math.random() * 2) == 0) {
	    number = 2;
	}
	else {
	    number = 4;
	}

	values[column][row] = number;
    }

    public Integer[][] getValues() {
	return values;
    }

    public void keyReleased(KeyEvent ev) {}
    public void keyTyped(KeyEvent ev) {}
}
