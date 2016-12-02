/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multinomial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

/**
 *
 * @author danielmartinez
 */
public class Frecuency {
    String path = "/Users/danielmartinez/NetBeansProjects/Multinomial/ClassC/doc1.txt";
    Map<String,Integer> frecuencia;
    
    public Frecuency(){
        frecuencia = new HashMap();
    }
    
    public void map() throws FileNotFoundException, IOException{
                String entrada;
                BufferedReader bf = new BufferedReader(new FileReader(path));
                entrada = bf.readLine();
                StringTokenizer tokenizer = new StringTokenizer(entrada);
               
                while ( tokenizer.hasMoreTokens()) {
                        String palabra = tokenizer.nextToken().toLowerCase();
                       
                        if (frecuencia.containsKey(palabra)) {
                                int cuenta = frecuencia.get(palabra);
                              //  int aux = cuenta/mapa.size();
                              int aux = cuenta/frecuencia.size();
                                frecuencia.put(palabra, cuenta + 1);
                        }
                        else
                                frecuencia.put(palabra, 1);
                }
        
    }
    
    
        public void mostrarMap() {
               
                Set<String> claves = frecuencia.keySet();
               
                TreeSet<String> clavesOrd = new TreeSet<String>(claves);
               
                System.out.println("El mapa contiene: \nClave\t\tValor");
               
                for (String clave : clavesOrd)
                        System.out.printf("%-10s%10s\n",clave, frecuencia.get(clave));
               
                //System.out.printf("hola", frecuencia.size());//
               
        }
}
