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
    /**
     * 1. Se inicializara un arrayList de tipo BigInteger
     * 2. Se generaran numeros int al azar, luego seran convertidos a BigInteger.
     * 3. Si el GREATEST COMMON DIVISOR es 1 entre ambos numeros generados, se agregan.
     * 4. Retornar arrayList..
     * @return arrayList de BigIntegers relativos
     */
    public ArrayList generadorRelativos(){
       ArrayList<BigInteger> primos = new ArrayList<BigInteger>();
       SecureRandom rdn = new SecureRandom();
       Integer num1, num2, constante;
       BigInteger bigNum1, bigNum2, Bigconstante, gcd;
       constante=1;
       boolean cond;
       Bigconstante= BigInteger.valueOf(constante);
       for (int i=0; i<=300; i++){
           //retorna entre 0 y 9999999
           num1=rdn.nextInt(18);
           num2=rdn.nextInt(36);
           //se realiza la conversion a BigInteger de num1 y num2 para tener acceso a metodo GCD.
           bigNum1= BigInteger.valueOf(num1.intValue());
           bigNum2= BigInteger.valueOf(num2.intValue());
           //Si no son igual a 1 el GCD no se agrega a la lista....
           cond=checkRelativos(bigNum1, bigNum2);
           if(cond){
               primos.add(bigNum1);
               primos.add(bigNum2);
           }
       }
       return primos;
    }
    public boolean checkRelativos(BigInteger x, BigInteger y){
        boolean determinacion=false;
        BigInteger gcd;
        BigInteger cosa;
        Integer valor=1;
        cosa = BigInteger.valueOf(valor.intValue());
        gcd=x.gcd(y);
        if(gcd.equals(cosa)){
           determinacion=true;
        }
        return determinacion;
    }
            
}
            
       
        
 
    

