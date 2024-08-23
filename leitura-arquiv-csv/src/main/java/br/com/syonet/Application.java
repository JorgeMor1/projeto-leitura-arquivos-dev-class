package br.com.syonet;

import java.util.ArrayList;
import java.util.List;

    /*  Mantive somente a classe  BufferedReaderExample, 
    *   porque pelos testes ela lia mais rápido (em menos milesegundos) 
    */
import br.com.syonet.io.BufferedReaderExample;
/*import br.com.syonet.io.FileInputStreamExemple;
import br.com.syonet.nio.FilesReadExample;
import br.com.syonet.nio.NIOFileReaderExemple;*/

public class Application {


    public static void main(String[] args) {

        String filePath = "meus_dados.csv"; //Define o caminho do arquivo CSV
        List<String> csvLines = readCsvLines(filePath); //Chamo o método readCsvLines() e armazeno na lista csvLines;
        Converter converter = new Converter(); //Objeto Converter() instanciado;


        List<Filial> filiais = converter.processCsvLines(csvLines);

        /*
        * Tirei o for, porque só queria imprimir o resultado de uma vez, sem imprimir toda lista;
        for (Filial filial : filiais) {
            System.out.println(filial);
        }*/

        Filial filialComMaiorMedia = encontrarFilialComMaiorMedia(filiais);
        System.out.println("==================================================================");
        System.out.println("Filial com a maior média de visitas:");        
        if (filialComMaiorMedia != null) {
            System.out.println(filialComMaiorMedia);
        } else {
            System.out.println("Nenhuma filial encontrada.");
        }

        
        BufferedReaderExample bufferedReaderExample = new BufferedReaderExample("meus_dados.csv");
        bufferedReaderExample.execute();
        /*System.out.println("-------------------------------------------------------------\n" +
                           "                                 FIM\n" +
                           "-------------------------------------------------------------");*/        
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


