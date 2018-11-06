/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradorsa;

import java.math.BigInteger;
import java.util.Random;
/**
 * Clase que modela todos los calculos necesarios para encriptar y desencriptar 
 * con el algoritmo RSA
 * PROYECTO DE MATEMATICA DISCRETA
 * @author Francisco Molina y Maria Fernanda Lopez
 * @version 5/11/2018
 */
public class encriptador {
    
    int tamanoPrimo;
    private BigInteger p,q,n;
    private BigInteger mod_d;
    private BigInteger e, d;

    public encriptador(int tamPrimo){
        tamanoPrimo = tamPrimo;
        GenerarClaves();
    }
    
       
    /**
     * Metodo para generar todos los numeros primos necesarios y claves para r
     * realizar la encriptacion/desencriptacion
     * 
     */
    public void GenerarClaves(){
        
        //se generan los numeros primos 
         p = new BigInteger(tamanoPrimo, 10, new Random());
         
         //se calcula la variable q a partir de la variable p 
        do
            q = new BigInteger(tamanoPrimo, 10, new Random());
        while (q.compareTo(p) == 0);  //lo realiza hasta que ambas variables son iguales
        
        //se generan las claves a partir de los numeros calculados
        n = p.multiply(q);
        
        mod_d = p.subtract(BigInteger.valueOf(1));
        mod_d = mod_d.multiply(q.subtract(BigInteger.valueOf(1)));
        
        do{
            e = new BigInteger(2*tamanoPrimo, new Random());
        }
        while (e.compareTo(mod_d) != 1 || e.gcd(mod_d).compareTo(BigInteger.valueOf(1)) != 0);
            d = e.modInverse(mod_d);         
    }
    public BigInteger ObtenerD_dado(Integer pPara, Integer qPara, Integer eValue){
       //Variables a utilizar:::
       BigInteger mod_Big_D,bigD;
       //convertimos a bigInteger los valores dados.
       BigInteger bigP = BigInteger.valueOf(pPara);
       BigInteger bigQ = BigInteger.valueOf(qPara);
       BigInteger bigE = BigInteger.valueOf(eValue);
       mod_Big_D = bigP.subtract(BigInteger.valueOf(1));
       mod_Big_D = mod_Big_D.multiply(bigQ.subtract(BigInteger.valueOf(1)));
        
       while (bigE.compareTo(mod_Big_D) != 1 || bigE.gcd(mod_Big_D).compareTo(BigInteger.valueOf(1)) != 0);
            bigD = bigE.modInverse(mod_Big_D);
            
      return bigD;
    }
    public BigInteger ObtenerN_dado(Integer pPara, Integer qPara){
       BigInteger bigN;
       BigInteger bigP = BigInteger.valueOf(pPara);
       BigInteger bigQ = BigInteger.valueOf(qPara);
       bigN = bigP.multiply(bigQ);
        System.out.println(bigN);
       return bigN;
    }
        
    
    
    /**
     * Se calcula el largo de los bloques a encriptar/desencriptar
     * @return  largo de los bloques
     */
    public BigInteger bloques(BigInteger N_Value){
         BigInteger bloques = BigInteger.valueOf(0);
        BigInteger numsBloqs[] = new BigInteger[13];
        String N = "25";
        String m = "";
        for(int i = 0; i<13; i++){
            m+=N;
            numsBloqs[i] = new BigInteger(m);
            int res = N_Value.compareTo(numsBloqs[i]);
            if(res == 1){
                bloques = numsBloqs[i];
            }
        }
        
        return bloques;
        
    }
    
    /**
     * metodo que separa el mensaje en sus respectivos bloques de n largo
     * @param mensaje mensaje a encriptar/desencriptar
     * @param bloques largo de los bloques
     * @return vector con cada bloque de texto de n (bloques) de largo
     */
    public String[] separar_mensaje(String mensaje, String bloques){
        //declaracion de variables
        int x = mensaje.length();   
        int bloques1 = bloques.length();
        int division = x/bloques1;
        int residuo = x%bloques1;
        int tamanio = division;  
        
        if (residuo!=0){
             tamanio = division+1;
        } else {
            tamanio = division;
        }
        
        String[] bloques_encriptar;
        bloques_encriptar = new String[tamanio];
        String temp = mensaje;
        for(int i = 0; i<tamanio; i++){
            if(temp.length()>bloques1){
                bloques_encriptar[i] = temp.substring(0, bloques1);
                temp = temp.substring(bloques1);
            } else {
                for(int j = temp.length(); j<bloques1; j++){   //si no es del mismo largo se llena los espacios de diferencia con 0
                    temp+="0";
                }
                bloques_encriptar[i] = temp;
            }
                        
            temp = temp;
        }
        return bloques_encriptar; 
    }
    
        public BigInteger[] encriptar(String[] mensaje, BigInteger E_value, BigInteger N_value){
        BigInteger[] encriptado = new BigInteger[mensaje.length];
  
        for(int i = 0; i<mensaje.length; i++){
            BigInteger bloque = new BigInteger(mensaje[i]);
            encriptado[i] = bloque.modPow(E_value, N_value); 
            
          
        }
       
          
       return encriptado;
    }
    
    /**
     * Metodo que realiza el desencriptado de un mensaje de forma texto^e mod n
     * @param cifrado  vector que contiene el texto cifrado separados en sus respectivos bloques
     * @param bloques  largo de los numeros a decifrar
     * @return  texto desencriptado 
     */
    public String desencriptar(BigInteger[] cifrado, String bloques, BigInteger D_Value, BigInteger N_Value){
        Alfabeto abc = new Alfabeto();
        //declaracion de variables
        int bloques1 = bloques.length();
        String mensaje = "";
        String rellenado = "";
        
        String individual = "";  //esta variable sirve para conocer el numero resultante de la exponención que deberia de tener el mismo largo de cada bloque calculado
        for(int i = 0; i<cifrado.length; i++){
            individual = cifrado[i].modPow(D_Value, N_Value).toString();  //se calcula y se guarda como un string
            if(individual.length()==bloques1){    //si es igual al largo del bloque calculado que lo guarde en el vector de texto decencriptado
                mensaje+=cifrado[i].modPow(D_Value, N_Value);
      
            } else {
                for(int h = individual.length(); h<bloques1; h++){   //de lo contrario es porque el bloque comenzaba con n cantidad de 0 entonces que le agregue la diferencia entre bloques.le - indivual.len de ceros
                    rellenado+="0";
                }
                rellenado+=individual;
            
                mensaje+=rellenado;
                rellenado = "";
            }
            
        }
        
        //se seapara el mensaje decencriptado en números de 2 en 2 pues sus correspondientes en letras es un string de 2 caracteres que forma un número 
        //se guarda en un vector temporal tipo string, en cada pos se encuentra una letra
        String temp = mensaje;
        String [] bloques_decencriptar = new String[(mensaje.length()/2)+1];
        for(int i = 0; i<(mensaje.length()/2)+1; i++){
            if(temp.length()>2){
                bloques_decencriptar[i] = temp.substring(0, 2);
                temp = temp.substring(2);
            } else {
                for(int j = temp.length(); j<2; j++){
                    temp+="0";
                }
                bloques_decencriptar[i] = temp;
            }
                        
            temp = temp;
        }
        
        //Aqui comienza a pasarse el mensaje ya decencriptado en numeros a sus correspondientes en letras
        String mfinal = "";
        for(int i = 0; i<bloques_decencriptar.length; i++){
            mfinal+=abc.abc(bloques_decencriptar[i]);
        }
        
        return mfinal;
    }
    
    public String prueba_d(BigInteger nump, BigInteger numq, BigInteger nume, BigInteger[] encriptado){
       
        Alfabeto abc = new Alfabeto();
        BigInteger numn = nump.multiply(numq);
        BigInteger modphi = nump.subtract(BigInteger.valueOf(1));
        modphi = modphi.multiply(numq.subtract(BigInteger.valueOf(1)));
        BigInteger numd = nume.modInverse(modphi);
        String mensaje = "";
        String rellenado = "";
        String x = bloques(numn).toString();
        int bloques1 = x.length();
        
        System.out.println(bloques1);
        String individual = "";  //esta variable sirve para conocer el numero resultante de la exponención que deberia de tener el mismo largo de cada bloque calculado
        for(int i = 0; i<encriptado.length; i++){
            individual = encriptado[i].modPow(numd, numn).toString();  //se calcula y se guarda como un string
            System.out.println(individual);
            if(individual.length()==bloques1){    //si es igual al largo del bloque calculado que lo guarde en el vector de texto decencriptado
                mensaje+=encriptado[i].modPow(numd, numn);
      
            } else {
                for(int h = individual.length(); h<bloques1; h++){   //de lo contrario es porque el bloque comenzaba con n cantidad de 0 entonces que le agregue la diferencia entre bloques.le - indivual.len de ceros
                    rellenado+="0";
                }
                rellenado+=individual;
            
                mensaje+=rellenado;
                rellenado = "";
            }
            
        }
        
        System.out.println(mensaje);
        //se seapara el mensaje decencriptado en números de 2 en 2 pues sus correspondientes en letras es un string de 2 caracteres que forma un número 
        //se guarda en un vector temporal tipo string, en cada pos se encuentra una letra
        String temp = mensaje;
        String [] bloques_decencriptar = new String[(mensaje.length()/2)+1];
        for(int i = 0; i<(mensaje.length()/2)+1; i++){
            if(temp.length()>2){
                bloques_decencriptar[i] = temp.substring(0, 2);
                temp = temp.substring(2);
            } else {
                for(int j = temp.length(); j<2; j++){
                    temp+="0";
                }
                bloques_decencriptar[i] = temp;
            }
                        
            temp = temp;
        }
        
        //Aqui comienza a pasarse el mensaje ya decencriptado en numeros a sus correspondientes en letras
        String mfinal = "";
        for(int i = 0; i<bloques_decencriptar.length; i++){
            System.out.println(bloques_decencriptar[i]);
            mfinal+=abc.abc(bloques_decencriptar[i]);
        }
        
        return mfinal;
       
        
    }
    
    //getters
 

    public BigInteger getP() {
        return p;
    }

    public BigInteger getQ() {
        return q;
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getMod_d() {
        return mod_d;
    }

    public BigInteger getE() {
        return e;
    }

    public BigInteger getD() {
        return d;
    }
  
            
}
            
       
        
 
    

