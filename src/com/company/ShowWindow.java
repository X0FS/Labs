package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowWindow extends Window {

    private JTextField IDt, Datat;
    private JLabel ID, Data;
    private JButton ButData, AllData;
    List TheList;

    ShowWindow(String title, List m1){
        super( title );
        TheList = m1;

        setLayout( new GridLayout(3,2 ) );

        ID      = new JLabel( "Поиск по ID" );
        IDt     = new JTextField( " " );
        Data    = new JLabel( "Поиск по ключу?" );
        Datat   = new JTextField( " " );
        ButData = new JButton( "Просмотр" );
        AllData = new JButton( "Просмотр всех записей" );

        add( ID );
        add( IDt );
        add( Data );
        add( Datat );
        add( ButData );
        add( AllData );

        ActionListener checker = new eHandler( );
        ButData.addActionListener( checker );
        AllData.addActionListener( checker );

    }

    private class eHandler implements ActionListener {
        @Override
        public void actionPerformed ( ActionEvent e ) {
            if ( e.getSource( ).equals( ButData ) ) {
               try{
                    if (TheList.IdIsValid(IDt.getText())) {
                        TheList.printList(Integer.parseInt(IDt.getText().trim()), null);
                    }else{
                        TheList.printList(-1, Datat.getText().trim());
                    }

                }catch (Exception error){
                    JOptionPane.showMessageDialog(null,"У вас ошибка, возможно, вы ввели некорректные значения " + error);
                }
            }
            if ( e.getSource( ).equals( AllData ) ) {
                TheList.printList(-2, null );
            }
        }
    }
}
