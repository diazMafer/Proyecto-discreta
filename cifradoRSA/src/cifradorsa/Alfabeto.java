/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradorsa;

/**
 *
 * @author Mafer
 */
public class Alfabeto{
    public Alfabeto(){}
    public String abc_numerico(String letra){
        String x = "00";
        if(letra.equals("A")){
            x = "01";
        }
        if(letra.equals("B")){
            x = "02";
        }
        if(letra.equals("C")){
            x = "03";
        }
        if(letra.equals("D")){
            x = "04";
        }
        if(letra.equals("E")){
            x = "05";
        }
        if(letra.equals("F")){
            x = "06";
        }
        if(letra.equals("G")){
            x = "07";
        }
        if(letra.equals("H")){
            x = "08";
        }
        if(letra.equals("I")){
            x = "09";
        }
        if(letra.equals("J")){
            x = "10";
        }
        if(letra.equals("K")){
            x = "11";
        }
        if(letra.equals("L")){
            x = "12";
        }
        if(letra.equals("M")){
            x = "13";
        }
        if(letra.equals("N")){
            x = "14";
        }
        if(letra.equals("O")){
            x = "15";
        }
        if(letra.equals("P")){
            x = "16";
        }
        if(letra.equals("Q")){
            x = "17";
        }
        if(letra.equals("R")){
            x = "18";
        }
        if(letra.equals("S")){
            x = "19";
        }
        if(letra.equals("T")){
            x = "20";
        }
        if(letra.equals("U")){
            x = "21";
        }
        if(letra.equals("V")){
            x = "22";
        }
        if(letra.equals("W")){
            x = "23";
        }
        if(letra.equals("X")){
            x = "24";
        }
        if(letra.equals("Y")){
            x = "25";
        }
        if(letra.equals("Z")){
            x = "26";
        }
        if(letra.equals("!")){
            x = "27";
        }
        if(letra.equals("?")){
            x = "28";
        }
        if(letra.equals("¿")){
            x = "29";
        }
        if(letra.equals("¡")){
            x = "30";
        }
        if(letra.equals(".")){
            x = "31";
        }
        if(letra.equals(",")){
            x = "32";
        }
        return x;
    }
    
    public String abc(int a){
        String C=null;
        if(a==0){
            C=" ";
        }else if(a==1){
            C="a";
        }else if(a==2){
            C="b";
        }else if(a==3){
            C="c";
        }else if(a==4){
            C="d";
        }else if(a==5){
            C="e";
        }else if(a==6){
            C="f";
        }else if(a==7){
            C="g";
        }else if(a==8){
            C="h";
        }else if(a==9){
            C="i";
        }else if(a==10){
            C="j";
        }else if(a==11){
            C="k";
        }else if(a==12){
            C="l";
        }else if(a==13){
            C="m";
        }else if(a==14){
            C="n";
        }else if(a==15){
            C="o";
        }else if(a==16){
            C="p";
        }else if(a==17){
            C="q";
        }else if(a==18){
            C="r";
        }else if(a==19){
            C="s";
        }else if(a==20){
            C="t";
        }else if(a==21){
            C="u";
        }else if(a==22){
            C="v";
        }else if(a==23){
            C="w";
        }else if(a==24){
            C="x";
        }else if(a==25){
            C="y";
        }else if(a==26){
            C="z";
        }
        return C;
    }
}