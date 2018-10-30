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
       ArrayList<paresRelativos> primos = new ArrayList<paresRelativos>();
       SecureRandom rdn = new SecureRandom();
       Integer num1, num2;
       BigInteger bigNum1, bigNum2, Bigconstante, gcd;
       boolean cond;
       paresRelativos par;
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
               primos.add(par);
           }
       }
       return primos;
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
        Integer valor=1;
        cosa = BigInteger.valueOf(valor.intValue());
        gcd=x.gcd(y);
        if(gcd.equals(cosa)){
           determinacion=true;
        }
        return determinacion;
    }
    /**
     * funcion que retorna p*q, se asegura que ni p y q sean 0 para mejorar seguridad y posibles fallos de el algoritmo
     * @param primos array de paresRelativos
     * @return n de encripcion.
     */
    public BigInteger getN(ArrayList<paresRelativos> primos){
        Random rnd = new Random();
        paresRelativos x;
        BigInteger num1, num2,res;
        x= primos.get(rnd.nextInt(primos.size()));
        //nos aseguramos que entre los pares no exista ningun 0. 
        while((x.num1.equals(0)) || (x.num2.equals(0))){
            x=primos.get(rnd.nextInt(primos.size()));
        }
        num1=x.num1;
        num2=x.num2;
        
        res=num1.multiply(num2);
        //obtenemos n del RSA.
        return res;
    }
    /**
     * TO-DO...
     * @param primos
     * @return 
     */
    public BigInteger getE(ArrayList<paresRelativos> primos){
        Random rnd = new Random();
        paresRelativos x;
        BigInteger num1, num2,gcd1,gcd2,eValue;
        Integer e;
        e=rnd.nextInt(128);
        
        eValue= BigInteger.valueOf(e.intValue());
        num1= primos.get(rnd.nextInt(primos.size())).num1.subtract(BigInteger.ONE);
        num2= primos.get(rnd.nextInt(primos.size())).num2.subtract(BigInteger.ONE);
        // gcd(e,p-1)=gcd(e,q-1)=1
        
        return eValue;
    }
            
}
            
       
        
 
    

