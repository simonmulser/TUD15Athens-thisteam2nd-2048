package com.thisteam2nd.game2048;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Game extends JPanel implements KeyListener {
	
	private Integer[][] boardValues = new Integer[][]{
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0}
	};

    private static final Color BG_COLOR = new Color(0xC4F1BE);

    public Game(){
        setFocusable(true);
        addKeyListener(this);
        addRandomValue();
        addRandomValue();
        repaint();
    }

    public void keyPressed(KeyEvent ev) {
        int keyCode =  ev.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            magic();
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            boardValues = Transformation.reverse(boardValues);
            magic();
            boardValues = Transformation.reverse(boardValues);
        } else if (keyCode == KeyEvent.VK_UP) {
            boardValues = Transformation.rotate90(Transformation.rotate90(Transformation.rotate90(boardValues)));
            magic();
            boardValues = Transformation.rotate90(boardValues);
        } else if (keyCode == KeyEvent.VK_DOWN) {
            boardValues = Transformation.rotate90(boardValues);
            magic();
            boardValues = Transformation.rotate90(Transformation.rotate90(Transformation.rotate90(boardValues)));
        }

        addRandomValue();
        repaint();
    }

    private void magic() {
        for(int i = 0; i < 4; i++){
            boardValues[i] = Logic.mergeLine(Logic.moveLine(boardValues[i]));
        }
    }

    public void keyReleased(KeyEvent ev) {}
    public void keyTyped(KeyEvent ev) {}

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.setColor(BG_COLOR);
        graphics.fillRect(0,0, this.getSize().width, this.getSize().height);
        Graphics2D graphichs2D = (Graphics2D) graphics;

        graphichs2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphichs2D.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        final Font font = new Font("Helvetica", Font.BOLD, 36);
        graphichs2D.setFont(font);

        Rectangle[][] rectangles = GameBoardBuilder.create();
        for(int i = 0; i < rectangles.length; i++){
            for(int j = 0; j < rectangles[i].length; j++){
                graphichs2D.setColor(new Color(0x5C5B7F));
                Rectangle rect = rectangles[i][j];
                graphichs2D.fillRoundRect(rect.getX(), rect.getY(), Rectangle.side, Rectangle.side, Rectangle.arc, Rectangle.arc);

                if(boardValues[i][j] != 0) {
	                graphichs2D.setColor(new Color(0x3C4356));
	                String value = String.valueOf(boardValues[i][j]);
	                final FontMetrics fm = getFontMetrics(font);
	                final int stringWidth = fm.stringWidth(value);
	                final int stringHeight = -(int) fm.getLineMetrics(value, graphichs2D).getBaselineOffsets()[2];
	
	                graphichs2D.drawString(
	                        value,
	                        rect.getX() + (Rectangle.side - stringWidth)/2,
	                        rect.getY() + Rectangle.side - (Rectangle.side - stringHeight)/2 - 2);
                }
            }
        }
    }

    public void addRandomValue() {
        int column, row;
        int number;

        do{
            column = (int)(Math.random() * 4);
            row = (int)(Math.random() * 4);
        } while(boardValues[column][row] != 0);

        if ((int)(Math.random() * 2) == 0) {
            number = 2;
        }
        else {
            number = 4;
        }

        boardValues[column][row] = number;
    }
}
