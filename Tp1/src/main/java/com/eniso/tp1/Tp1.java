/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eniso.tp1;
import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author HP
 */
public class Tp1 {
    
    public static double[] calculateProbability(int[][] image)
    {
        int ROWS = image.length;
        int COLS = image[0].length;
        double[] prob = new double[256];
        
        for (int i = 0; i < 256; i++)
        {
            int occ = 0;
            for (int j = 0; j < ROWS; j++)
            {
                for (int k = 0; k < COLS; k++)
                {
                    if (image[j][k] == i)
                    {
                        occ++;
                    }
                }
            }
            
            double P = (double) occ / (ROWS * COLS); 
            prob[i] = P;
        }
        
        return prob;
    }
    
    public static double calculateEntropy(int[][] image)
    {
        double[] prob = calculateProbability(image);
        double h=0;
        
        for (int i = 0; i< 256; i++)
        {
            if(prob[i] != 0)
            {
                h += prob[i]*(Math.log(prob[i])/Math.log(2));
            }
        }
        
        return -h;
    }
    
    public static void main(String[] args)
    {
        
        /*=========================== EXERCICE 2 ================================*/
        System.out.println("Bonjour, mon premier TP en POO");
        
        //lecture du nom
        System.out.println("Quelle est votre nom ? ");
        Scanner read = new Scanner(System.in);
        String name = read.next();
        
        //Lecture de l'age
        System.out.println();
        System.out.println("Bonjour " + name);
        System.out.println("Quel est votre age " + name + "?");
        read = new Scanner(System.in);
        int a;
        a = read.nextInt();
        System.out.println(name + " Votre age est " + a);
        
        /*=========================== EXERCICE 3 ================================*/
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[] prob = calculateProbability(matrix);
        
        System.out.println("Matrice : ");
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
              System.out.print(matrix[i][j] + " |");  
            }
            System.out.print("\n");
        }
        
        System.out.print("\n");
        
        for (int i = 0; i < prob.length; i++)
        {
            System.out.println("Probabilite d'occurences " + i + ": " + prob[i]);
        }
        
        System.out.println("Probabilite d'Entropie : " + calculateEntropy(matrix));
    
    }
    
}
