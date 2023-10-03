package com.kurveps.filemanagement.commands;

import com.kurveps.filemanagement.service.FileService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class FileCommands {
    private final FileService fileService;

    public FileCommands(FileService fileService) {
        this.fileService = fileService;
    }

    @ShellMethod(key = "cum", value = "accumulates files with same extension in same folder")
    public String accumulate(@ShellOption(defaultValue = " ") String path){
        if(path.equals(" ")){
            return "Empty Path  is not acceptable";
        }
        fileService.create(path);
        return  "Go Check your Directory" ;
    }

}
