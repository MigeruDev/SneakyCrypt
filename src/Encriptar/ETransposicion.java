/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Encriptar;

import java.util.Arrays;

/**
 *
 * @author The Worst One
 */
public class ETransposicion {
    public String encriptar(int key, String message){
        String cifrado[] = new String[key];
       for (int i=0; i<cifrado.length;i++)
           cifrado[i]="";
       
       int pointer = 0;
       for (int col=0; col < key;col++)
       {
           pointer = col;
           while(pointer < message.length())
           {
               cifrado[col] += message.charAt(pointer);
               pointer += key; 
           }
       }
       String textCifrado = "";
        for (String cifrado1 : cifrado)
            textCifrado += cifrado1;
 
       return textCifrado;
    }
    
    public void encriptarShow(int key, String message){
        String cifrado[] = new String[key];
       for (int i=0; i<cifrado.length;i++)
           cifrado[i]="";
       
       int pointer = 0;
       for (int col=0; col < key;col++)
       {
           pointer = col;
           while(pointer < message.length())
           {
               cifrado[col] += message.charAt(pointer);
               pointer += key;
           }
       }
       pointer = 0;
       boolean flag = true;
       while(flag)
       {
           for (int i = 0; i < cifrado.length; i++)
           {
               if (pointer < cifrado[i].length())
               {
                   System.out.print(cifrado[i].charAt(pointer)+"\t");
               }else{
                   flag = false;
                   break;
               }
           }
           System.out.println("");
           pointer++;
       }
    }
    
}
