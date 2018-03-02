package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWindow extends Window{

    private JTextField IDt, Datat;
    private JLabel ID, Data;
    private JButton ButData;
    List TheList;

    AddWindow( String title, List m1){
        super( title );
        TheList = m1;
        setLayout( new GridLayout (3,2 ) );

        ID      = new JLabel( "ID" );
        Data    = new JLabel( "Данные" );
        IDt     = new JTextField( "" );
        Datat   = new JTextField( "" );
        ButData = new JButton( "Внести изменения" );



        add( ID );
        add( Data );
        add( IDt );
        add( Datat );
        add( ButData );

        ActionListener checker = new eHandler( );
        ButData.addActionListener( checker );

    }

    private class eHandler implements ActionListener {
        @Override
        public void actionPerformed ( ActionEvent e ) {
            if ( e.getSource( ).equals( ButData ) )  {
                try {
                    if (IDt.getText().trim().length() == 0) {
                        TheList.addWithID(-1, Integer.parseInt(Datat.getText().trim()));
                    } else {
                        if (Integer.parseInt(IDt.getText().trim()) == 0){
                            TheList.addWithID(Integer.parseInt(IDt.getText().trim()), Integer.parseInt(Datat.getText().trim()));
                        } else {
                            if ((TheList.gettailid() >= Integer.parseInt(IDt.getText().trim())) && (Integer.parseInt(IDt.getText().trim()) > -1)) {
                                TheList.addWithID(Integer.parseInt(IDt.getText().trim()), Integer.parseInt(Datat.getText().trim()));
                            } else {
                                JOptionPane.showMessageDialog(null, "ID не может быть меньше 0 или больше " + TheList.gettailid());
                            }
                        }
                    }
                }catch (Exception error){JOptionPane.showMessageDialog(null, "У вас ошибка, возможно, вы ввели некорректные значения " + error);

                }
            }
        }
    }



}
