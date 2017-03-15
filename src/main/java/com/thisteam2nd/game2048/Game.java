package com.thisteam2nd.game2048;

import com.thisteam2nd.game2048.command.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Game implements KeyListener{

    private volatile static Game instance;

    private JFrame frame;
    private GameBoard board;

    private HashMap<Integer, Command> map = new HashMap<Integer, Command>();

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

	map.put(KeyEvent.VK_LEFT, new LeftCommand());
    map.put(KeyEvent.VK_RIGHT, new RightCommand());
    map.put(KeyEvent.VK_DOWN, new DownCommand());
    map.put(KeyEvent.VK_UP, new UpCommand());

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
	Command cmd = map.get(ev.getKeyCode());

	if(cmd != null){
        Integer[][] tempValues = deepCopyValues();
		cmd.execute();
        if (!boardsAreEqual(values, tempValues)) {
            addRandomValue();
        }
		board.repaint();
	} else {
		System.out.println("no cmd found for key");
	}
	board.repaint();
    }

    public Integer[][] getValues() {
	return values;
    }

    public void setValues(Integer[][] values) {
    	this.values = values;
	}

    public void keyReleased(KeyEvent ev) {}
    public void keyTyped(KeyEvent ev) {}

    private void addRandomValue() {
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

    private Integer[][] deepCopyValues() {
        Integer[][] copyValues = new Integer[values.length][];
        for (int i=0; i < values.length; i++) {
            copyValues[i] = new Integer[values[i].length];
            System.arraycopy(values[i], 0, copyValues[i], 0, values[i].length);
        }
        return copyValues;
    }

    private boolean boardsAreEqual(Integer[][] board1, Integer[][] board2) {
        for (int i=0; i < board1.length; i++) {
            for (int j=0; j <board1[0].length; j++) {
                if (!board1[i][j].equals(board2[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
