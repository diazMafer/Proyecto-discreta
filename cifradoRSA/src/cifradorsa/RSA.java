/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradorsa;

import java.math.BigInteger;
import static java.math.BigInteger.valueOf;


/**
 *
 * @author Mafer
 */
public class RSA {
 
    public RSA(){}
    
    public BigInteger[] encriptar(BigInteger e, BigInteger n, String mensaje){
        Byte[] temp = new Byte[1];
        byte[] digitos = mensaje.getBytes();
        BigInteger[] bigDigitos = new BigInteger[digitos.length];
        int x;
        
        for(int i = 0; i<digitos.length; i++){
            temp[0] = digitos[i];
            x = temp[0];
            bigDigitos[i] = BigInteger.valueOf(x);            
        }
        System.out.println("AQUI empiezan LOS BYTES");
        BigInteger[] encriptado = new BigInteger[bigDigitos.length];
        for(int j =0; j<encriptado.length; j++){
             encriptado[j] = bigDigitos[j].modPow(e, n);  
             System.out.println(encriptado[j]);
        }
       System.out.println("AQUI TERMINAN LOS BYTES");
        
        return encriptado;
    }
    
    
    public BigInteger desencriptar(BigInteger n, BigInteger p, BigInteger q, BigInteger e, BigInteger cifrado){
        BigInteger a = BigInteger.valueOf(0);
        
        
        
        return a;
        
    }
}
