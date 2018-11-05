/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradorsa;

import java.math.BigInteger;
import java.util.Random;
/**
 *
 * @author Francisco Molina
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
     * Se encarga de verificar si dos numeros son dos primos relativos 
     * 
     */
    public void GenerarClaves(){
         p = new BigInteger(tamanoPrimo, 10, new Random());
        do
            q = new BigInteger(tamanoPrimo, 10, new Random());
        while (q.compareTo(p) == 0);
        
        n = p.multiply(q);
        
        mod_d = p.subtract(BigInteger.valueOf(1));
        mod_d = mod_d.multiply(q.subtract(BigInteger.valueOf(1)));
        
        do{
            e = new BigInteger(2*tamanoPrimo, new Random());
        }
        while (e.compareTo(mod_d) != 1 || e.gcd(mod_d).compareTo(BigInteger.valueOf(1)) != 0);
            d = e.modInverse(mod_d);
                
    }
    
    
    public BigInteger bloques(){
        BigInteger bloques = BigInteger.valueOf(0);
        BigInteger numsBloqs[] = new BigInteger[13];
        String N = "25";
        String m = "";
        for(int i = 0; i<13; i++){
            m+=N;
            numsBloqs[i] = new BigInteger(m);
            int res = n.compareTo(numsBloqs[i]);
            if(res == 1){
                bloques = numsBloqs[i];
            }
        }
        
        return bloques;
    }
    
    public String[] separar_mensaje(String mensaje, String bloques){
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
                for(int j = temp.length(); j<bloques1; j++){
                    temp+="0";
                }
                bloques_encriptar[i] = temp;
            }
                        
            temp = temp;
        }
        return bloques_encriptar; 
    }
   
    public BigInteger[] encriptar(String[] mensaje){
        BigInteger[] encriptado = new BigInteger[mensaje.length];
  
        for(int i = 0; i<mensaje.length; i++){
            BigInteger bloque = new BigInteger(mensaje[i]);
            encriptado[i] = bloque.modPow(e, n); 
            
          
        }
       
          
       return encriptado;
    }
    
    public void desencriptar(BigInteger[] cifrado, String bloques){
        Alfabeto abc = new Alfabeto();
        int bloques1 = bloques.length();
        String mensaje = "";
        String rellenado = "";
        String individual = "";
        for(int i = 0; i<cifrado.length; i++){
            individual = cifrado[i].modPow(d, n).toString();
            if(individual.length()==bloques1){
                mensaje+=cifrado[i].modPow(d, n);
      
            } else {
                for(int h = individual.length(); h<bloques1; h++){
                    rellenado+="0";
                }
                rellenado+=individual;
            
                mensaje+=rellenado;
                rellenado = "";
            }
            
        }
        
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
        
        String mfinal = "";
        for(int i = 0; i<bloques_decencriptar.length; i++){
            mfinal+=abc.abc(bloques_decencriptar[i]);
        }
        System.out.println("MENSAJE DESENCRIPTADO");
        System.out.println(mfinal.toUpperCase());
    }

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
            
       
        
 
    

