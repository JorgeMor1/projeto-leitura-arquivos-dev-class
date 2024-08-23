package br.com.syonet.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import br.com.syonet.FileReaderExemple;

public class FilesReadExample extends FileReaderExemple  {
    public FilesReadExample(String filePath) {
        super(filePath);
      }
      
      public void execute() {
        Path path = Paths.get(this.filePath);
        try {
          List<String> lines = Files.readAllLines(path);
          lines.forEach(System.out::println);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
}
