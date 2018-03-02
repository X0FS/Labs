package com.company;

import javax.swing.*;
import java.awt.*;

public class Output extends Window {

    private JTextField IDt, Datat;
    private JLabel ID, Data;
    private JButton ButData, AllData;

    Output(String title){
        super(title);
        setLayout( new GridLayout(3,2 ) );
    }


}
