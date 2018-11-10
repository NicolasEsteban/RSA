/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;
import java.math.BigInteger;


public class Funciones {
    public BigInteger generar_rango(int n){
        String s="1";
        int i;
        for(i=1;i<n;i++){
            s= s+"1";
        }
        
        BigInteger I=new BigInteger(s);
        return I;
    }
    
    public int Primalidad(BigInteger n){//funcion para determinar la primalidad
        BigInteger mod,aux,m=null ,base= new BigInteger("2");
        BigInteger aux2,aux3=new BigInteger("1");
        int res,i=0,k=1,x=2;
        int j=0;
        // n-1=(2^k)*m
        aux=n.subtract(new BigInteger("1"));       
        mod = aux.mod(base.pow(k));
        
        while(i==0){ //se divide y se sacan los modulo para obtener los valores de k y m
            aux=aux.divide(base.pow(k));
            if(mod.compareTo(new BigInteger("0"))==0){
                m=aux;
                aux=n.subtract(new BigInteger("1"));
                k=k+1;
                mod = aux.mod(base.pow(k));
                //System.out.println(m);
            }else{
                i=1;
            }
        }
        
        while(x>0){ // se obtiene el valor de x que empieza en 2
            aux2=n.gcd(new BigInteger(""+x));
            if(aux2.compareTo(new BigInteger("1"))==0){
                break;
            }
            else{
                x++;
            }
        }
        
        BigInteger b [] = new BigInteger[k]; // arreglo b para almacenar la secuencia 
        // se examina la secuencia para determinar para saber si el numero es probablemente primo o no
        for(j=0;j<k;j++){
            b[j]=base.modPow(base.pow(j).multiply(m), n);
            System.out.println(b[j]);
        }
        int verificador=1;
        if(b[0].compareTo(new BigInteger("1"))==0){
            System.out.println("Probablemente Primo");
            return 1;
        }else{
        
            if(b[k-1].compareTo(new BigInteger("1"))==0){
                for(j=k-2;j>=0;j--){
                    if(b[j].compareTo(new BigInteger("1"))==0){
                        verificador=0;
                    }
                }
                if(verificador==0){
                    System.out.println("Numero Compuesto");
                    return 0;
                }else{
                    System.out.println("Probablemente Primo");
                    return 1;
                }
            }else{
               System.out.println("Numero Compuesto");
               return 1;
            }
        }
        
        
    }
    
}


