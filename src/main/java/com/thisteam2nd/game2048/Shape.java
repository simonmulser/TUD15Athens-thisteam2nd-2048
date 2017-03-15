package com.thisteam2nd.game2048;

import java.awt.FontMetrics;
import java.awt.Graphics2D;

public interface Shape {
	
	void paint(Graphics2D graphics2D);
	
	void paintValue(Graphics2D graphics2D,FontMetrics fm, int value);
}
