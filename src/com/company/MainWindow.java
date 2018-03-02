package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainWindow extends Window {
    private JButton AddNewData, RemoveData, ShowData, Filler, Sort;
    List TheList;

    MainWindow( String title){
        super( title );
        TheList = new List();

        setLayout( new GridLayout (3,2 ) );

        AddNewData = new JButton( "Ввести новые элементы" );
        RemoveData = new JButton( "Удалить штучки" );
        ShowData   = new JButton( "Просмотр данных" );
        Filler     = new JButton( "Наполнить структуру" );
        Sort       = new JButton( "Сортировка" );

        add( AddNewData );
        add( RemoveData );
        add( ShowData );
        add( Filler );
        add( Sort );

        ActionListener checker = new eHandler( );

        AddNewData.addActionListener( checker );
        RemoveData.addActionListener( checker );
        ShowData  .addActionListener( checker );
        Filler    .addActionListener( checker );
        Sort      .addActionListener( checker );

    }
    private class eHandler implements ActionListener{
        @Override
        public void actionPerformed ( ActionEvent e ) {
            if ( e.getSource( ).equals( AddNewData ) ){
                Window p = new AddWindow( "Окно ввода", TheList );
                p.setLocationRelativeTo ( null );
                p.setVisible( true );
                p.pack( );
            }
            if ( e.getSource( ).equals( RemoveData ) ){
                Window p = new RemoveWindow( "Окно удаления", TheList );
                p.setLocationRelativeTo ( null );
                p.setVisible( true );
                p.pack( );
            }
            if ( e.getSource( ).equals( ShowData ) ){
                Window p = new ShowWindow( "Просмотр", TheList );
                p.setLocationRelativeTo ( null );
                p.setVisible( true );
                p.pack( );
            }
            if ( e.getSource( ).equals( Filler ) ){
                Random rnd = new Random(System.currentTimeMillis());
                for (int i = 0; i <101; i++){
                    TheList.addWithID(-1, rnd.nextInt(1000));
                }
                JOptionPane.showMessageDialog( null,"Наполнили");

            }
            if ( e.getSource( ).equals( Sort ) ){
                TheList.Sort();
                JOptionPane.showMessageDialog( null,"Отсортировали");

            }

        }
    }


}
