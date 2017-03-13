package com.thisteam2nd.game2048;

import javax.swing.*;

public class App 
{
    public static void main( String[] args )
    {
        JFrame frame = new JFrame();
        frame.setTitle("this team second - 2048");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.add(new Game());

        frame.setSize(340, 400);
        frame.setVisible(true);
    }
}
