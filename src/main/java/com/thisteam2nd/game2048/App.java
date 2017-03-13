package com.thisteam2nd.game2048;

import javax.swing.*;

public class App 
{
    public static void main( String[] args )
    {
        JFrame frame = new JFrame();
        frame.setTitle("this team second - 2048");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setSize(655,685);
        frame.add(new Game());

        frame.setVisible(true);
        frame.setResizable(false);
    }
}
