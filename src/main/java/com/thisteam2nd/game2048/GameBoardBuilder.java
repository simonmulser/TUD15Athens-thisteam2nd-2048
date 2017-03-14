package com.thisteam2nd.game2048;

public class GameBoardBuilder {

    public static Rectangle[][] create() {
        Rectangle[][] rectangles = new Rectangle[4][];
        for (int i = 0; i < 4; i++) {
            rectangles[i] = new Rectangle[4];

            for (int j = 0; j < 4; j++) {
                rectangles[i][j] = new Rectangle(
                        i * Rectangle.side + i * Rectangle.spacing + Rectangle.spacing,
                        j * Rectangle.side + j * Rectangle.spacing + Rectangle.spacing);
            }
        }
        return rectangles;
    }
}
