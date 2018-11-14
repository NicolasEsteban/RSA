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
        
        BigInteger p,q,I, N, F, p1, q1;
        
        Funciones funcion = new Funciones();
        
        I = funcion.generar_rango(numero_digitos);
        
        Random rnd = new Random();
        System.out.println("Claves privadas");
        p = BigInteger.probablePrime(I.bitLength(), rnd);
        p=funcion.buscar_primo(p, I);
        
        q = BigInteger.probablePrime(I.bitLength(), rnd);
        q=funcion.buscar_primo(q, I);
        
        System.out.println("p "+p);
        System.out.println("q "+q);
        
        
        N=p.multiply(q); // N= p*q
        
        System.out.println("N= "+N);
        p1=p.subtract(new BigInteger("1"));
        q1=q.subtract(new BigInteger("1"));
        F=p1.multiply(q1); // F= (p-1)*(q-1)
        
        System.out.println("F="+F);
        
    }
    
}
