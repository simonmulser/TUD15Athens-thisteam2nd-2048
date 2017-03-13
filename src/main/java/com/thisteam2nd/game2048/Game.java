package com.thisteam2nd.game2048;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {

    private static final Color BG_COLOR = new Color(0xC4F1BE);

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

        final Font font = new Font("Helvetica", Font.BOLD, 36);
        graphichs2D.setFont(font);

        Rectangle[][] rectangles = GameBoardBuilder.create();
        for(int i = 0; i < rectangles.length; i++){
            for(int j = 0; j < rectangles[i].length; j++){
                graphichs2D.setColor(new Color(0x5C5B7F));
                Rectangle rect = rectangles[i][j];
                graphichs2D.fillRoundRect(rect.getX(), rect.getY(), rect.side, rect.side, rect.arc, rect.arc);

                graphichs2D.setColor(new Color(0x3C4356));
                String value = String.valueOf(0);
                final FontMetrics fm = getFontMetrics(font);
                final int stringWidth = fm.stringWidth(value);
                final int stringHeight = -(int) fm.getLineMetrics(value, graphichs2D).getBaselineOffsets()[2];

                graphichs2D.drawString(
                        value,
                        rect.getX() + (rect.side - stringWidth)/2,
                        rect.getY() + rect.side - (rect.side - stringHeight)/2 - 2);
            }
        }
    }
}
