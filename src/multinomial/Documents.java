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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author danielmartinez
 */
public class Documents {
    String path;
    String path2;
    List<String> documentWords;
     Map<String,List<String>> mapfilesC = new HashMap();
     Map<String,List<String>> mapfilesJ = new HashMap();
    
    public Documents(String ruta1, String ruta2){
        path = ruta1;
        path2 = ruta2;
        documentWords = new ArrayList();
    }
    
     public void getWordsClassC() throws FileNotFoundException, IOException{
            BufferedReader bf = null;    
            String line = null;
            File origin = new File(path);
            if(origin.isDirectory()){
                String[] files = origin.list();                   
                for(int i = 0; i < files.length; i++){                 
                    bf = new BufferedReader(new FileReader(path + files[i]));
                    while((line = bf.readLine())!= null){
                        line= line.replaceAll("[,;.-_]"," ");
                        StringTokenizer st = new StringTokenizer(line, " ");
                        while(st.hasMoreTokens()){
                            documentWords.add(st.nextToken());
                        }
                        mapfilesC.put(files[i], documentWords);
                    }
                    bf.close();
                }
            }
        }
          
     public void getWordsClassJ() throws FileNotFoundException, IOException{
            BufferedReader bf = null;    
            String line = null;
            File origin = new File(path2);
            if(origin.isDirectory()){
                String[] files = origin.list();                   
                for(int i = 0; i < files.length; i++){                 
                    bf = new BufferedReader(new FileReader(path2 + files[i]));
                    while((line = bf.readLine())!= null){
                        line= line.replaceAll("[,;.-_]"," ");
                        StringTokenizer st = new StringTokenizer(line, " ");
                        while(st.hasMoreTokens()){
                            documentWords.add(st.nextToken());
                        }
                        mapfilesJ.put(files[i], documentWords);
                    }
                    bf.close();
                }
            }
        }
    
}
