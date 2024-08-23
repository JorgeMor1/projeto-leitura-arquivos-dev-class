package br.com.syonet;

import java.util.ArrayList;
import java.util.List;

import br.com.syonet.io.BufferedReaderExample;
import br.com.syonet.io.FileInputStreamExemple;
import br.com.syonet.nio.FilesReadExample;
import br.com.syonet.nio.NIOFileReaderExemple;

public class Application {

    public static void main(String[] args) {

        String filePath = "meus_dados.csv";
        List<String> csvLines = readCsvLines(filePath);
        Converter converter = new Converter();
        List<Filial> filiais = converter.processCsvLines(csvLines);
        /*System.out.println("Objetos Filial convertidos:");*/
        for (Filial filial : filiais) {
            System.out.println(filial);
        }

        Filial filialComMaiorMedia = encontrarFilialComMaiorMedia(filiais);
        System.out.println("==================================================================");
        System.out.println("==================================================================");
        System.out.println("==================================================================");
        System.out.println("Filial com a maior média de visitas:");        
        if (filialComMaiorMedia != null) {
            System.out.println(filialComMaiorMedia);
        } else {
            System.out.println("Nenhuma filial encontrada.");
        }

        FileInputStreamExemple fileInputStreamExemple = new FileInputStreamExemple("meus_dados.csv");
        fileInputStreamExemple.execute();        
        //System.out.println("-----------------------------------------------------------------------");
        
        //start = System.currentTimeMillis();
        BufferedReaderExample bufferedReaderExample = new BufferedReaderExample("meus_dados.csv");
        bufferedReaderExample.execute();

        //System.out.println("-----------------------------------------------------------------------");
        
        NIOFileReaderExemple nioFileReaderExemple = new NIOFileReaderExemple("meus_dados.csv");
        nioFileReaderExemple.execute();
        
        //System.out.println("-----------------------------------------------------------------------");

        FilesReadExample filesReadExample = new FilesReadExample("meus_dados.csv");
        filesReadExample.execute();

        /*System.out.println("-------------------------------------------------------------\n" +
                           "                                 FIM\n" +
                           "-------------------------------------------------------------");*/

        //filesReadExampleTime = System.currentTimeMillis() - start;
        
    }
     private static List<String> readCsvLines (String filePath) {
        List<String> lines = new ArrayList<>();
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private static Filial encontrarFilialComMaiorMedia(List<Filial> filiais) {
        Filial filialComMaiorMedia = null;
        double maiorMedia = 0;

        for (Filial filial : filiais) {
            double mediaVisitas = calcularMediaVisitas(filial.getVisitasMensais());
            if (mediaVisitas > maiorMedia) {
                maiorMedia = mediaVisitas;
                filialComMaiorMedia = filial;
            }
        }
        return filialComMaiorMedia;
    }

    private static double calcularMediaVisitas(List<Integer> visitasMensais) {
        if (visitasMensais.isEmpty()) {
            return 0;
        }
        int soma = visitasMensais.stream().mapToInt(Integer::intValue).sum();
        return (double) soma / visitasMensais.size();
    }
}


