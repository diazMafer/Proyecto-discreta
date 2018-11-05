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
    
    public String abc(String a){
        String C=null;
        if(a.equals("00")){
            C=" ";
        }else if(a.equals("01")){
            C="a";
        }else if(a.equals("02")){
            C="b";
        }else if(a.equals("03")){
            C="c";
        }else if(a.equals("04")){
            C="d";
        }else if(a.equals("05")){
            C="e";
        }else if(a.equals("06")){
            C="f";
        }else if(a.equals("07")){
            C="g";
        }else if(a.equals("08")){
            C="h";
        }else if(a.equals("09")){
            C="i";
        }else if(a.equals("10")){
            C="j";
        }else if(a.equals("11")){
            C="k";
        }else if(a.equals("12")){
            C="l";
        }else if(a.equals("13")){
            C="m";
        }else if(a.equals("14")){
            C="n";
        }else if(a.equals("15")){
            C="o";
        }else if(a.equals("16")){
            C="p";
        }else if(a.equals("17")){
            C="q";
        }else if(a.equals("18")){
            C="r";
        }else if(a.equals("19")){
            C="s";
        }else if(a.equals("20")){
            C="t";
        }else if(a.equals("21")){
            C="u";
        }else if(a.equals("22")){
            C="v";
        }else if(a.equals("23")){
            C="w";
        }else if(a.equals("24")){
            C="x";
        }else if(a.equals("25")){
            C="y";
        }else if(a.equals("26")){
            C="z";
        }else if(a.equals("27")){
            C="!";
        }else if(a.equals("28")){
            C="?";
        }else if(a.equals("29")){
            C="¿";
        }else if(a.equals("30")){
            C="¡";
        }else if(a.equals("31")){
            C=".";
        }else if(a.equals("32")){
            C=",";
        }
        return C;
    }
}