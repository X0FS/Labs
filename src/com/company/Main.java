package com.company;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;

public class Main{

    public static void main ( String[] args ) {
        Window w = new MainWindow ( "Hello" );
        w.setVisible ( true );
        w.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        w.pack();
        w.setLocationRelativeTo ( null );
    }

}

//NU TI PONYAL, PES

