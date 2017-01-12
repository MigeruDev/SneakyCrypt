/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Desencriptar;

/**
 *
 * @author The Worst One
 */
public class DTransposicion {
    
    
    public String desencriptar(int key, String message){
        
       int columns = (int) Math.ceil((double)message.length()/(double)key);
       int rows = key;
       int blank = (columns*rows)-message.length();
       
       String [] descifrado = new String[columns];
       for (int i=0; i<descifrado.length;i++)
           descifrado[i]="";
       
       int col=0, row=0;
       
       for(String x: message.split(""))
       {
           descifrado[col]+=x;
           col++;
           if ((col==columns) || (col==columns-1 && row >= rows-blank)  )
           {
               col = 0; row++;
           }
       }
       
       String textDescifrado = "";
        for (String cifrado1 : descifrado)
            textDescifrado += cifrado1;
           
        return textDescifrado;
    }
    
    public void desencriptarShow(int key, String message){
       int columns = (int) Math.ceil((double)message.length()/(double)key);
       int rows = key;
       int blank = (columns*rows)-message.length();
       
       String [] descifrado = new String[columns];
       for (int i=0; i<descifrado.length;i++)
           descifrado[i]="";
       
       int col=0, row=0;
       
       for(String x: message.split(""))
       {
           descifrado[col]+=x;
           col++;
           if ((col==columns) || (col==columns-1 && row >= rows-blank)  )
           {
               col = 0; row++;
           }
       }
       
        int pointer = 0;
       boolean flag = true;
       while(flag)
       {
           for (int i = 0; i < descifrado.length; i++)
           {
               if (pointer < descifrado[i].length())
               {
                   System.out.print(descifrado[i].charAt(pointer)+"\t");
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
