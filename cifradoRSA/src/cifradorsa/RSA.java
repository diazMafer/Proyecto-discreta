/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradorsa;

import java.math.BigInteger;



/**
 *
 * @author Mafer
 */
public class RSA {
 
    public RSA(){}
    
    public BigInteger[] encriptar(String[] mensaje, BigInteger e, BigInteger n){
        BigInteger[] encriptado = new BigInteger[mensaje.length];
        System.out.print("BLOQUESITOS ENCRIPTADOS");
        System.out.println();
        for(int i = 0; i<mensaje.length; i++){
            BigInteger bloque = new BigInteger(mensaje[i]);
            encriptado[i] = bloque.modPow(e, n); 
            System.out.println(encriptado[i]);
          
        }
       
       System.out.println("AQUI TERMINAN");
       System.out.println();
        
       return encriptado;
    }
    
    
    public void desencriptar(BigInteger n, BigInteger p, BigInteger q, BigInteger e, BigInteger[] cifrado){
        Alfabeto abc = new Alfabeto();
        BigInteger mod_d = p.subtract(BigInteger.valueOf(1)).multiply(q.subtract(BigInteger.valueOf(1)));
        BigInteger d = e.modInverse(mod_d);
        String mensaje = "";
        System.out.println();
        System.out.println("BLOQUES DESENCRIPTADOS");
        for(int i = 0; i<cifrado.length; i++){
            System.out.println(cifrado[i].modPow(d, n));
            mensaje+=cifrado[i].modPow(d, n);
        }
        System.out.println("falta pasarlo a letras pero deberia de salir lo mismo que de numeros");
        System.out.print(mensaje);
        
        //falta pasarlo a letras
    }

   

}
