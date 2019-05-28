package me.prestonwhitehurst.filenamerandomizer;

import java.util.Random;

public class RandomString {
    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static Random rnd = new Random();

    public static String create(int len) {
        StringBuilder sb = new StringBuilder(len);
        
        for(int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        
        return sb.toString();
    }
}
