/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

/**
 *
 * @author The Worst One
 */
public class Sneaky {
    
    private List<String>sherlock; 
    
    public Sneaky() {
        sherlock = new ArrayList<>();
        sherlock.add("E");
        sherlock.add("A");
        sherlock.add("O");
        sherlock.add("S");
        sherlock.add("R");
        sherlock.add("N");
        sherlock.add("I");
        sherlock.add("D");
        sherlock.add("L");
        sherlock.add("C");        
    }   
    
    public boolean cryptanalysis (String codigo){
        SortedSet<Map.Entry<String, Integer>> frecuencias = 
                ContadorComparator.sortByValue(new Contador().frecuenciaChar(codigo));
        
        int indice = 0;
        int analizador=0;
        String caracter = "";
        
        System.out.println(frecuencias);
        
        for(Map.Entry<String,Integer> frecuency: frecuencias){
            if (indice<=10 && indice<=frecuencias.size())
            {
                caracter = frecuency.getKey();
                
                if (sherlock.contains(caracter))
                    analizador++;
                indice++;
            }
            else
                break;
        }
        
        
        if (frecuencias.size()<=10 )
        {
            if (analizador>=frecuencias.size()/2)
                return true;
            else
                return false;
        }else if (frecuencias.size()>10 && frecuencias.size()<=15)
        {
            if (analizador>=5)
                return true;
            else
                return false;
        } else if (frecuencias.size()>15 && analizador>=7)
            return true;
        else
            return false;      
    }
}
