package com.thisteam2nd.game2048;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class Rectangle implements Shape{
    private int x;
    private int y;
    public final static int side = 150;
    public final static int arc = 10;
    public final static int spacing = 10;

    public Rectangle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public Color getColor() {
    	return new Color(0x3C4356);
    }

	public void paint(Graphics2D graphics2d) {
		graphics2d.fillRoundRect(getX(), getY(), Rectangle.side, Rectangle.side, Rectangle.arc, Rectangle.arc);
		
	}

	public void paintValue(Graphics2D graphics2d, FontMetrics fm, int value) {
		graphics2d.setColor(new Color(0x3C4356));
        String valueStr = String.valueOf(value);
        
        final int stringWidth = fm.stringWidth(valueStr);
        final int stringHeight = -(int) fm.getLineMetrics(valueStr, graphics2d).getBaselineOffsets()[2];

        graphics2d.drawString(
                valueStr,
                getX() + (Rectangle.side - stringWidth)/2,
                getY() + Rectangle.side - (Rectangle.side - stringHeight)/2 - 2);		
	}

}
