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
    }
}
