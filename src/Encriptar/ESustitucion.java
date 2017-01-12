/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Encriptar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author The Worst One
 */
public class ESustitucion {
    
    private List<String> abc;
    private List<String> ABC;

    public ESustitucion() {
        abc = new ArrayList();
        ABC = new ArrayList();
        abc.add("a");        abc.add("b");
        abc.add("c");        abc.add("d");
        abc.add("e");        abc.add("f");
        abc.add("g");        abc.add("h");
        abc.add("i");        abc.add("j");
        abc.add("k");        abc.add("l");
        abc.add("m");        abc.add("n");
        abc.add("ñ");        abc.add("o");
        abc.add("p");        abc.add("q");
        abc.add("r");        abc.add("s");
        abc.add("t");        abc.add("u");
        abc.add("v");        abc.add("w");
        abc.add("x");        abc.add("y");
        abc.add("z");
        for (Iterator<String> it = abc.iterator(); it.hasNext();) {
            String x = it.next();
            ABC.add(x.toUpperCase());
        }
    }  
    
    public String encriptar(int key, String message)
    {
        String cifrado="";
        
        for(String x: message.split("")){
            if (abc.contains(x))
                cifrado+=abc.get( (abc.indexOf(x)+key >=abc.size() )? 
                        (abc.indexOf(x)+key)-(abc.size()) : abc.indexOf(x)+key );
            else if (ABC.contains(x))
                cifrado+=ABC.get( (ABC.indexOf(x)+key>=ABC.size() )? 
                        (ABC.indexOf(x)+key)-(ABC.size()) : ABC.indexOf(x)+key );
            else
                cifrado +=x;
        }
        
        return cifrado;
    }
}
