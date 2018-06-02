/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Arrays;

/**
 *
 * @author david
 */
public class Palabras {
    public int ran;
    public String plbrs [];
    public String ranwor;
    public String res [];
    
    

    public Palabras() {
         plbrs = new String [30];
         //  ** Palabras  **
        plbrs[0]="Colombia".toUpperCase();
        plbrs[1]="Cafe".toUpperCase();
        plbrs[2]="Guacamaya".toUpperCase();
        plbrs[3]="Amazonia".toUpperCase();
        plbrs[4]="Francia".toUpperCase();
        plbrs[5]="Banano".toUpperCase();
        plbrs[6]="Bogota".toUpperCase();
        plbrs[7]="Japon".toUpperCase();
        plbrs[8]="Brasil".toUpperCase();
        plbrs[9]="Manzana".toUpperCase();
        plbrs[10]="Granadilla".toUpperCase();
        plbrs[11]="Medellin".toUpperCase();
        plbrs[12]="Uchuva".toUpperCase();
        plbrs[13]="Cartagena".toUpperCase();
        plbrs[14]="Argentina".toUpperCase();
        plbrs[15]="Belgica".toUpperCase();
        plbrs[16]="cali".toUpperCase();
        plbrs[17]="Venezuela".toUpperCase();
        plbrs[18]="Papaya".toUpperCase();
        plbrs[19]="Mandarina".toUpperCase();
        plbrs[20]="Tigre".toUpperCase();
        plbrs[21]="Chimpance".toUpperCase();
        plbrs[22]="Guayaba".toUpperCase();
        plbrs[23]="Washington".toUpperCase();
        plbrs[24]="California".toUpperCase();
        plbrs[25]="Mora".toUpperCase();
        plbrs[26]="Sandia".toUpperCase();
        plbrs[27]="Inglaterra".toUpperCase();
        plbrs[28]="China".toUpperCase();
        plbrs[29]="Rusia".toUpperCase();
    }
    
    public String randomWord(){
        //Genera una palabra aleatoriamente
        ran = (int) 0 + (int) (Math.random() * ((plbrs.length - 1) + 1));
        System.out.println(plbrs[ran]);
        return plbrs[ran];
    }
    

    
    
}
