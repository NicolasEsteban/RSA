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
    
}
