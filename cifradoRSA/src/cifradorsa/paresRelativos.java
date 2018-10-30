/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradorsa;

import java.math.BigInteger;

/**
 * Por motivos de simplificacion operacional en la encriptacion, se crea una clase que contenga 2 bigIntegers que SEAN primos relativos.
 * @author Francisco Molina
 */
public class paresRelativos {
    public BigInteger num1; 
    public BigInteger num2;
    
    public paresRelativos(BigInteger num1, BigInteger num2){
        this.num1=num1;
        this.num2=num2;
    }
    public BigInteger getNumeroUno(){
        return num1;
    }
    public BigInteger getNumeroDos(){
        return num2;
    }
    
}
