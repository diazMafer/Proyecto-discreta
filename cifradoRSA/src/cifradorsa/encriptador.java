/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradorsa;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Francisco Molina
 */
public class encriptador {

    public encriptador(){
    }
    public ArrayList generadorRelativos(){
       ArrayList<BigInteger> primos = new ArrayList<BigInteger>();
       BigInteger x,y;
        BigInteger n = new BigInteger("9999999");
        for(int i=0; i<=200; i++){
            x=new BigInteger(n.bitLength(), new SecureRandom()).mod(n);
            y=new BigInteger(n.bitLength(), new SecureRandom()).mod(n);
            //asegurnarnos que sean primos relativos. 
            if(x.gcd(y)==BigInteger.ONE){
                primos.add(x);
                primos.add(y);
            } else{
                //nothing
            }
        }
            return primos;
        }
            
        }
        
 
    

