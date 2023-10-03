package com.kurveps.filemanagement.methods;

import java.util.HashMap;

public class FileMethods {
    public static String[] useful_Extensions = {"csv","py","ipynb","zip","jpg","cpp","png","docx","pptx","txt","pdf","jpeg","svg","blend"};
    public static HashMap<String,String> map = new HashMap<>();

    static String sourcePath = "C:\\Users\\kurve\\Documents";
    public void create_directories(){
        for(String s: useful_Extensions){
            map.put(s.toUpperCase(),s+"Directory");
        }
    }

    public boolean checkExtension(String ext){
        for(String s:useful_Extensions){
            if(s.equals(ext)){
                return true;
            }
        }
        return false;
    }

    public static  String getExtension(String filename){
        int index = filename.lastIndexOf('.');
        if(index>0){
            return filename.substring(index+1);
        }
        return " ";
    }
}
