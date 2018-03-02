package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveWindow extends Window {

    private JTextField IDt;
    private JLabel ID;
    private JButton ButData;
    List TheList;

    RemoveWindow( String title, List m1){
        super( title );
        TheList = m1;
        setLayout( new GridLayout(2,2 ) );

        ID      = new JLabel( "ID" );
        IDt     = new JTextField( "" );
        ButData = new JButton( "Внести изменения" );

        add( ID );
        add( IDt );
        add( ButData );

        ActionListener checker = new eHandler( );
        ButData.addActionListener( checker );

    }

    private class eHandler implements ActionListener {
        @Override
        public void actionPerformed ( ActionEvent e ) {
            if ( e.getSource( ).equals( ButData ) ) {
                try {
                    TheList.DeleteElem(Integer.parseInt(IDt.getText().trim()));
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Введите валидный id");
                }
            }
        }
    }
}
