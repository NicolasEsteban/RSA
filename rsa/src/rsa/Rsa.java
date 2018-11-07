/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;

import java.util.Scanner;
import java.math.BigInteger;
import java.util.Random;
import modelos.Funciones;
/**
 *
 * @author Nicolas
 */
public class Rsa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int numero_digitos;
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el rango : ");
        numero_digitos = sc.nextInt();
        
        BigInteger p,q,I;
        
        Funciones rango = new Funciones();
        
        I = rango.generar_rango(numero_digitos);
        
        Random rnd = new Random();
        System.out.println("Claves privadas");
        p = BigInteger.probablePrime(I.bitLength(), rnd);
        System.out.println("p: "+p);
        
        q = BigInteger.probablePrime(I.bitLength(), rnd);
        System.out.println("q: "+q);
    }
    
}
