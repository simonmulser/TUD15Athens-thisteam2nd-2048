package com.thisteam2nd.game2048;

import javax.swing.*;

public class App 
{
    public static void main( String[] args )
    {
        JFrame game = new JFrame();
        game.setTitle("this team second - 2048");
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        game.setSize(340, 400);
        game.setVisible(true);
    }
}
