/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author The Worst One
 */
public class Contador {
    
    private Map<String,Integer> frecuency;
    private List<String> abc;

    public Contador() {
        frecuency = new TreeMap<>();
        abc = new ArrayList();
        abc.add("A");        abc.add("B");
        abc.add("C");        abc.add("D");
        abc.add("E");        abc.add("F");
        abc.add("G");        abc.add("H");
        abc.add("I");        abc.add("J");
        abc.add("K");        abc.add("L");
        abc.add("M");        abc.add("N");
        abc.add("Ñ");        abc.add("O");
        abc.add("P");        abc.add("Q");
        abc.add("R");        abc.add("S");
        abc.add("T");        abc.add("U");
        abc.add("V");        abc.add("W");
        abc.add("X");        abc.add("Y");
        abc.add("Z");
    }
    
    
    public Map<String,Integer> frecuenciaChar(String texto){
        for (int i=0; i<texto.length();i++){
            if (abc.contains(String.valueOf(texto.charAt(i)).toUpperCase())) // Aqui fue el cambio
            {
                if (frecuency.containsKey( String.valueOf(texto.charAt(i)).toUpperCase() ) )
                    frecuency.put(String.valueOf(texto.charAt(i)).toUpperCase(), 
                            frecuency.get( String.valueOf(texto.charAt(i)).toUpperCase() )+1 );
                else
                    frecuency.put(String.valueOf(texto.charAt(i)).toUpperCase(), 1);
            }
        }
        return frecuency;
    }
}
