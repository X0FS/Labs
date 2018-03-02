package com.company;

import java.util.Random;

public class RandString {

    private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final Random rnd = new Random();

    public static String GenerateRandomString(){
        StringBuffer randStr = new StringBuffer();
        for(int i = 0; i < 1 + rnd.nextInt(14); i++){
            int number = rnd.nextInt(CHAR_LIST.length());
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

}
