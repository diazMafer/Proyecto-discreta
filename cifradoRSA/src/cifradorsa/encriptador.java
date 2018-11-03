/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradorsa;

import java.math.BigInteger;
import static java.math.BigInteger.valueOf;
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
     * @return par objeto tipo paresRelativos que contiene el numero p y q
     */
    public paresRelativos generadorRelativos(){
       SecureRandom rdn = new SecureRandom();
       Integer num1, num2;
       BigInteger bigNum1 = BigInteger.valueOf(0);
       BigInteger bigNum2 = BigInteger.valueOf(0);
       BigInteger Bigconstante, gcd;
       boolean cond;
       paresRelativos par = new paresRelativos(bigNum1, bigNum2);
       for (int i=0; i<=300; i++){
           //retorna entre 0 y 9999999
           num1=rdn.nextInt(9999999);
           num2=rdn.nextInt(9999999);
           //se realiza la conversion a BigInteger de num1 y num2 para tener acceso a metodo GCD.
           bigNum1= BigInteger.valueOf(num1.intValue());
           bigNum2= BigInteger.valueOf(num2.intValue());
           //Si no son igual a 1 el GCD no se agrega a la lista....
           cond=checkRelativos(bigNum1, bigNum2);
           if(cond){
               //se agrega objeto de tipo parRelativo, contiene (x,y) numeros enteros relativos >:)
               par= new paresRelativos(bigNum1, bigNum2);
               
           }
       }
       return par;
    }
    /**
     * Se encarga de verificar si dos numeros son dos primos relativos 
     * @param x relativo 1
     * @param y relativo 2
     * @return retorna si es o no es relativo. 
     */
    public boolean checkRelativos(BigInteger x, BigInteger y){
        boolean determinacion=false;
        BigInteger gcd;
        BigInteger cosa;
        cosa = BigInteger.valueOf(1);
        gcd=x.gcd(y);
        if(gcd.equals(cosa)){
           determinacion=true;
        }
        return determinacion;
    }
    /**
     * funcion que retorna p*q, se asegura que ni p y q sean 0 para mejorar seguridad y posibles fallos de el algoritmo
     * @param par objeto de la clase paresRelativos
     * @return n de encripcion.
     */
    public BigInteger getN(paresRelativos par){
        paresRelativos x = par;
        BigInteger num1 = x.getNumeroUno();
        BigInteger num2 = x.getNumeroDos();
        BigInteger res=num1.multiply(num2);
        //obtenemos n del RSA.
        return res;
    }
    
    /**
     * Calcula la llave publica 'e' generando un numero al azar y comprobando que 
     * su mcd(e,p-1) y mcd(e,q-1) sea igual a 1, de lo contrario seguira generando
     * numeros al azar hasta encontrar uno que satisfaga la condicion
     * @param par objeto de paresRelativos que contiene p y q
     * @return eValue valor de e que cumple con las condiciones dadas
     */
    public BigInteger getE(paresRelativos par){
        Random rnd = new Random();
        paresRelativos x = par;
        BigInteger num1 = x.getNumeroUno(), num2 = x.getNumeroDos(),eValue;
        boolean gcd1 = false;
        boolean gcd2 = false;
        Integer e = 0;
        while(gcd1!=true || gcd2!=true){
            e=rnd.nextInt(250);
            gcd1 = checkRelativos(BigInteger.valueOf(e), num1.subtract(BigInteger.valueOf(1)));
            gcd2 = checkRelativos(BigInteger.valueOf(e), num2.subtract(BigInteger.valueOf(1)));
        }
        
        eValue = BigInteger.valueOf(e);
       
        return eValue;
    }
            
}
            
       
        
 
    

