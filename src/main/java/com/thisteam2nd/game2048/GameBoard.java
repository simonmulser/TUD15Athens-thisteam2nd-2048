package com.thisteam2nd.game2048;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class GameBoard extends JPanel {

	private static final Color BG_COLOR = new Color(0xBBADA0);

	public GameBoard(){
		setFocusable(true);
		requestFocusInWindow();
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
				graphichs2D.setColor(getColor(j, i));
				Rectangle rect = rectangles[i][j];
				graphichs2D.fillRoundRect(rect.getX(), rect.getY(), Rectangle.side, Rectangle.side, Rectangle.arc, Rectangle.arc);

				Integer[][] values = Game.getInstance().getValues();
				if(values[j][i] != 0) {
					graphichs2D.setColor(new Color(0x3C4356));
					String value = String.valueOf(values[j][i]);
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

	public Color getColor(int i, int j) {
		Game game = Game.getInstance();
		Integer[][] values = game.getValues();
		switch(values[i][j]) {
			case 2:    return new Color(0xeee4da);
			case 4:    return new Color(0xede0c8);
			case 8:    return new Color(0xf2b179);
			case 16:   return new Color(0xf59563);
			case 32:   return new Color(0xf67c5f);
			case 64:   return new Color(0xf65e3b);
			case 128:  return new Color(0xedcf72);
			case 256:  return new Color(0xedcc61);
			case 512:  return new Color(0xedc850);
			case 1024: return new Color(0xedc53f);
			case 2048: return new Color(0xedc22e);
		}

		return new Color(0xcdc1b4);
	}
}