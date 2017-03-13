package com.thisteam2nd.game2048;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {

    private static final Color BG_COLOR = new Color(0xAAAAAA);

    public Game(){
        repaint();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.setColor(BG_COLOR);
        graphics.fillRect(0,0, this.getSize().width, this.getSize().height);
        Graphics2D graphichs2D = (Graphics2D) graphics;

        graphichs2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphichs2D.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        graphichs2D.setColor(new Color(0x000000));

        Rectangle[][] rectangles = GameBoardBuilder.create();
        for(int i = 0; i < rectangles.length; i++){
            for(int j = 0; j < rectangles[i].length; j++){
                Rectangle rect = rectangles[i][j];
                graphichs2D.fillRoundRect(rect.getX(), rect.getY(), rect.side, rect.side, rect.arc, rect.arc);
            }
        }
    }
}
