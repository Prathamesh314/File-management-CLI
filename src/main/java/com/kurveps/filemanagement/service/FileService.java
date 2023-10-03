package com.kurveps.filemanagement.service;

import com.kurveps.filemanagement.methods.FileMethods;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;


public class FileService {

    private final FileMethods filemethods;

    public FileService(FileMethods filemethods) {
        this.filemethods = filemethods;
    }

    public void create(String sourcePath) {
        File f = new File(sourcePath);
        String destination = f.getPath();
        if(f.isDirectory()){
            File[] list = f.listFiles();
            for(File s: list){
                if(s.isFile()){
                    String extension = filemethods.getExtension(s.toString());
                    if(extension != " "){
                        if(filemethods.checkExtension(extension)){
                            File extensionDirs = new File(sourcePath, filemethods.map.get(extension));
                            if(!extensionDirs.exists()){
                                extensionDirs.mkdirs();
                            }

                            Path sourceFilePath =  s.toPath();
                            Path destinationFilePath = extensionDirs.toPath().resolve(s.getName());

                            try{
                                Files.move(sourceFilePath, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}
