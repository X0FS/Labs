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
                    if (IDt.getText().trim().length() != 0){
                        if (TheList.IdIsValid(IDt.getText())){
                            TheList.addWithID(Integer.parseInt(IDt.getText().trim()), Datat.getText().trim());
                        }else {
                            throw new Exception();
                        }
                    } else {
                        TheList.addWithID(-1, Datat.getText().trim());
                    }
                }catch (Exception error){JOptionPane.showMessageDialog(null, "У вас ошибка, возможно, вы ввели некорректные значения " + error);

                }
            }
        }
    }



}
