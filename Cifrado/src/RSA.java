
import java.math.BigInteger;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mafer
 */
public class RSA {
    static private BigInteger e,p,q,n,mod_d,d,cifrado;
      
    //n=p*q > mod_d=(p-1)*(q-1) > d=inv(e) mod_d
    //el contenido cifrado fue generado con a^65537 mod n
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String encriptado = sc.nextLine();
        e = new BigInteger("65537");
        System.out.print("Ingrese el numero p: ");
        p = new BigInteger(sc.nextBigInteger().toString());
        System.out.print("Ingrese el numero q: ");
        q = new BigInteger(sc.nextBigInteger().toString());
        System.out.print("Ingrese el texto cifrado: ");
        cifrado = new BigInteger(sc.nextBigInteger().toString());
        n = new BigInteger(p.multiply(q).toString());
        mod_d = p.subtract(BigInteger.valueOf(1)).multiply(q.subtract(BigInteger.valueOf(1)));
        d = e.modInverse(mod_d);
        BigInteger a = cifrado.modPow(d, n);
        String mensaje = a.toString();
        for(int i = 0; i<mensaje.length(); i+=2){
            
            char c = (char) Integer.parseInt(mensaje.substring(i, i+2));;
            
            if(c==0){
                break;
            }
            System.out.print(c);
        }    
    }
    
}
