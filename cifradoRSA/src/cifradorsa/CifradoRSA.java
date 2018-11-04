/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradorsa;

import java.math.BigInteger;
import java.util.Scanner;


/**
 *
 * @author Francisco Molina
 */
public class CifradoRSA {

    /**
     * todo en un puto main, salu2
     */
    public static void main(String[] args) {
        encriptador instance = new encriptador();
        Alfabeto alfabeto = new Alfabeto();
        paresRelativos numeros;
        RSA instance2 = new RSA();
        BigInteger p,q,e,n;
        boolean x=true;
        char cadena;
        Scanner sc = new Scanner(System.in);
        String msj, ans;
        
        System.out.println("Bienvenido, este programa encriptara/desencriptara en codificacion RSA");
        while(x){
            System.out.println("Escoga una opcion del menu:");
            System.out.println("1. Encriptar");
            System.out.println("2. Desencriptar");
            System.out.println("3. Ayuda");
            System.out.println("4. Salir");
            System.out.println("");
            System.out.println("Ingrese el numero de opcion::");
            ans=sc.nextLine();
            
            switch(ans){
                case "1":
                    //metodo de encriptar.
                    System.out.println("****PROCESO DE ENCRIPTACION****");
                    //se generan numeros relativos.
                    //La lista tiene pares relativos. Osea posicion: 0 y 1 son primos relativos entre si, 2 y 3 son entre si.
                    String mensaje = "UPLOAD THE VIDEO OF MY SISTER DOING RANDOM THINGS";
                    System.out.println(mensaje);
                    System.out.println();
                    numeros=instance.generadorRelativos();
                    p = numeros.getNumeroUno();
                    q = numeros.getNumeroDos();
                    e = instance.getE(numeros);
                    n = instance.getN(numeros);
                    System.out.println("IMPRIMIENDO P");
                    System.out.println(p);
                    System.out.println("IMPRIMIENDO Q");
                    System.out.println(q);
                    System.out.println("IMPRIMIENDO N");
                    System.out.println(n);
                    System.out.println("IMPRIMIENDO E");
                    System.out.println(e);
                    String prueba = "";
                    for(int i=0; i<mensaje.length(); i++){
                        cadena = mensaje.charAt(i);
                        prueba+= alfabeto.abc_numerico(String.valueOf(cadena));                        
                    }
                    System.out.println("IMPRIMIENDO MENSAJE EN NUMERO");
                    System.out.println(prueba);
                    System.out.println("IMPRIMIENDO EL LARGO DE LA CADENA DEL MENSAJE");
                    System.out.println(prueba.length());
                    System.out.println("");
                    BigInteger bloques = instance.bloques(n);
                    String tamanio = String.valueOf(bloques);
                    System.out.println("TAMAÑO DE LOS BLOQUES");
                    System.out.println(tamanio.length());
                    System.out.println("");
                    System.out.println("SEPARACION DEL MENSAJE");
                    String[] separados = instance.separar_mensaje(prueba, tamanio);
                    BigInteger encriptado[] = instance2.encriptar(separados, e, n);
                    String nose = "";
                    for(int i=0; i<encriptado.length; i++){
                        nose+=encriptado[i];
                    }
                    System.out.print(nose);
                    System.out.println("");
                    System.out.print("DESENCRIPTANDO");
                    System.out.println("");
                    instance2.desencriptar(n, p, q, e, encriptado);
                    break;
                case "2":
                    //metodo de desencriptar.
                    
                    break;
                case "3":
                    System.out.println("El cifrado RSA consiste en utilizar la multiplicacion de 2 primos relativos, p y q. ");
                    System.out.println("Luego, se escoge un valor e que tiene que ser primo relativo con p-1 y q-1.");
                    System.out.println("El resultado de la multiplicacion, entre p y q se llama n. La llave publica es (n,e)");
                    System.out.println("el resultado n, luego es comparado con cadenas de 25, se divide en el limite inferior de 25*x veces<n<25*x+1");
                    System.out.println("A cada letra se le asigna un valor numerico, se utilizara ascii en esta implementacion");
                    System.out.println("Se ejecuta C=M^e(mod n)");
                    System.out.println("los valores obteniddos es el mensaje encriptado.");
                    break;
                case "4":
                    x=false;
                    
                    
            }
        }
        
        
        
    }
    
}
