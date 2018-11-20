
package rsa;

import java.util.Scanner;
import java.math.BigInteger;
import java.util.Random;
import modelos.Funciones;

public class Rsa {

    
    public static void main(String[] args) {
        
        int numero_digitos;
do{        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el rango : ");
        numero_digitos = sc.nextInt();
}while(numero_digitos<100 || numero_digitos>300);//ciclo do-while que restringe que los números ingresados sean entre [100, 300]
        
        BigInteger p,q,I, N, F, p1, q1; /*declaracion de los enteros grandes: 
                                         p es el primer primo
                                         q es el segundo primo
                                         I es la variable para que genere el rango y que se le pasa a la función genera rango
                                         N es p multiplicado por q
                                         F es (p-1) multiplicado por (q-1)
                                         p1 es p-1
                                         q1 es q-1
        
        */
        
        Funciones funcion = new Funciones();
        
        I = funcion.generar_rango(numero_digitos);
        
        Random rnd = new Random();
        
        p = BigInteger.probablePrime(I.bitLength(), rnd);
        p=funcion.buscar_primo(p, I);
        
        q = BigInteger.probablePrime(I.bitLength(), rnd);
        q=funcion.buscar_primo(q, I);
        
        System.out.println("p = "+p);
        System.out.println("q = "+q);
        
        
        N=p.multiply(q); // N= p*q
        
        System.out.println("N = "+N);
        p1=p.subtract(new BigInteger("1"));
        q1=q.subtract(new BigInteger("1"));
        F=p1.multiply(q1); // F= (p-1)*(q-1)
        
        System.out.println("F = "+F);
        
        BigInteger e,d;
        e=funcion.generar_e(N, new BigInteger("1"));
        
        while(e.gcd(F).compareTo(new BigInteger("1"))!=0){
            e=funcion.generar_e(N, new BigInteger("1"));
        }
      
        System.out.println("e = "+e);// se imprime e
        
        d=e.modPow(new BigInteger("-1"), F);
        
        System.out.println("d = "+d);
        
        BigInteger M ;
        BigInteger X ;
        BigInteger Y ;
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Ingrese el mensaje:");
        M=sc2.nextBigInteger();
        System.out.println("M="+M);
        X=M.modPow(e, N);
        System.out.println("X="+X);
        Y=X.modPow(d, N);
        System.out.println("Y="+Y);

    }
    
}
