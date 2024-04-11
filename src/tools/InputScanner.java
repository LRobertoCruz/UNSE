/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.util.Scanner;

/**
 *
 * @author evak
 * @version 1.0-SNAPSHOT
 */
public class InputScanner {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static int readInt() {
        return sc.nextInt();
    }
    
    public static double readDouble() {
        return sc.nextDouble();
    }
    
    public static float readFloat() {
        return sc.nextFloat();
    }
    
    public static String readString() {
        return sc.nextLine();
    }
    
    public static void cleanBuffer() {
        sc.next();
    }
    
}
