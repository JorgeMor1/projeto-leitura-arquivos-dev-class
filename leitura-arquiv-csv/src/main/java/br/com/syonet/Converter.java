package br.com.syonet;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public Filial converter(String csvLine) {
        String[] values = csvLine.split(",");

        String nome = values[0];
        String endereco = values[1];
        String cidade = values[2];
        String codigoPostal = values[3];

        List<Integer> visitasMensais = new ArrayList<>();
        int visitasAnuais = 0;

        String[] visitasMensaisArray = values[4].split(";");
        for (int i = 0; i < visitasMensaisArray.length; i++) {
            int visita = Integer.parseInt(visitasMensaisArray[i]);
            visitasMensais.add(visita);
        }

        visitasAnuais = visitasMensais.stream().mapToInt(Integer::intValue).sum();

        String geolocalizacao = values[6];

        return new Filial(nome, endereco, cidade, codigoPostal, visitasMensais, visitasAnuais, geolocalizacao);
    }

    public List<Filial> processCsvLines(List<String> csvLines) {
        List<Filial> filiais = new ArrayList<>();
        for (String line : csvLines) {
            filiais.add(converter(line));
        }
        return filiais;
    }
}