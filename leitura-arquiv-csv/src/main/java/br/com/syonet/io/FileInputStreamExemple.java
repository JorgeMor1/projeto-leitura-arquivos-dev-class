package br.com.syonet.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.syonet.FileReaderExemple;

public class FileInputStreamExemple extends FileReaderExemple  {
    public FileInputStreamExemple(String filePath) {
        super(filePath);
      }
    
      public void execute() {
        try (FileInputStream fileInputStream = new FileInputStream(this.filePath)) {
          int content;
          List<Character> caracteres = new ArrayList<>();
          while ((content = fileInputStream.read()) != -1) {
            caracteres.add((char) content);
          }
          char[] str = new char[caracteres.size()];
          for (int i = 0; i < str.length; i++) {
            str[i] = caracteres.get(i);
          }
          //String resultado = String.valueOf(str);
          //System.out.println(resultado);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
}
