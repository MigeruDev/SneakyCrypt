/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;

/**
 *
 * @author The Worst One
 */
public class Bumblebee {
    
    private List<String> abc;
    private Map<String, Integer> frecuency;
    private Map<String, Integer> sherlock;
    private Map<String,String>watson;
    

    public Bumblebee() {
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
    
    public int honeyPot3(String message){
        int clave = -1;
        String caracter = "";
        
        SortedSet<Map.Entry<String, Integer>> frecuencias = 
                ContadorComparator.sortByValue(new Contador().frecuenciaChar(message)); // todas las frecuencias del texto
        
        frecuency = new HashMap<>(); // las primeras 10 frecuencias mas altas
        List<String>frecuencia=new ArrayList<>(); // Lista de solo los caracteres mas frecuentes
        int indice=0;
        Iterator<Map.Entry<String,Integer>> it = frecuencias.iterator();
        while(indice<10 && indice < frecuencias.size()){
            if (it.hasNext()){
                Map.Entry<String,Integer> x = it.next();
                frecuencia.add(x.getKey());
                frecuency.put( x.getKey(), x.getValue());
            }                
            indice++;
        }  

        sherlock = new HashMap<>(); // Sherlock contiene todas las posibles A
        // La clave es la A tentativa, y su valor es la frecuencia
        
        for (int i=0;i < frecuency.size()-1;i++)
        {
            for (int j =i+1; j<frecuency.size();j++)
            {
                if (abc.contains(frecuencia.get(i)) && abc.contains(frecuencia.get(j)))
                {
                    if (frecuencia.get(i).compareTo(frecuencia.get(j))<0)
                    {
                        if(location(frecuencia.get(i),frecuencia.get(j))==4)
                        {
                            sherlock.put(frecuencia.get(i), frecuency.get(frecuencia.get(i)));
                        }
                    }else
                    {
                        if(location(frecuencia.get(j),frecuencia.get(i))==4)
                        {
                            sherlock.put(frecuencia.get(j), frecuency.get(frecuencia.get(j)));
                        }                            
                    }
                }
            }
        }
                
        watson= new TreeMap<>(); // Key = O tentative - Value = A tentative
        
        for (String A:sherlock.keySet()){
            for (String f: frecuencia){
                if (!f.equals(A) && abc.contains(f) )
                {
                        if(location(A,f)==15)
                            watson.put(f, A); //
                }
            }
        }       
        
        if (watson.isEmpty())
        {
            int max=0;
            String key="";
            Iterator<String> ite = sherlock.keySet().iterator();
                while(ite.hasNext())
                {
                    String aux=ite.next();
                    if(sherlock.get(aux)>max){
                        max = sherlock.get(aux);
                        key=aux;
                    }
                }
            clave = location("A",key);
        }else if (watson.size()>1)
        {
            int max=0;
            String key = "";
            Iterator<String> ite = watson.values().iterator();
            while(ite.hasNext()){
                String aux = ite.next();
                if(sherlock.get(aux)>max){
                    max = sherlock.get(aux);
                    key=aux;
                }
            }
            clave = location("A",key);
        }else
          clave=location("A",watson.values().iterator().next());

        return clave;
    }
    
    
    
    public int location(String menor, String mayor){
        
        if (menor.compareTo(mayor)<0)
            return abc.indexOf(mayor)-abc.indexOf(menor);
        else
        {
            return (abc.size()-abc.indexOf(menor))+abc.indexOf(mayor);
        }
    }

    public Map<String, Integer> getFrecuency() {
        return frecuency;
    }

    public Map<String, String> getWatson() {
        return watson;
    }

    public Map<String, Integer> getSherlock() {
        return sherlock;
    }
    
    
}
