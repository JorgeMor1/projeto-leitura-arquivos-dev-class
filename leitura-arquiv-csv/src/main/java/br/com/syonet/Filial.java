package br.com.syonet;

import java.util.List;

public class Filial {
    private String nome;
    private String endereco;
    private String cidade;
    private String codigoPostal;
    private List<Integer> visitasMensais;
    protected int visitasAnuais;
    protected String geolocalizacao;

    public Filial(String nome, String endereco, String cidade, String codigoPostal, 
                  List<Integer> visitasMensais, int visitasAnuais, String geolocalizacao) {
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.codigoPostal = codigoPostal;
        this.visitasMensais = visitasMensais;
        this.visitasAnuais = visitasAnuais;
        this.geolocalizacao = geolocalizacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public List<Integer> getVisitasMensais() {
        return visitasMensais;
    }

    public void setVisitasMensais(List<Integer> visitasMensais) {
        this.visitasMensais = visitasMensais;
    }

    public int getVisitasAnuais() {
        return visitasAnuais;
    }

    public void setVisitasAnuais(int visitasAnuais) {
        this.visitasAnuais = visitasAnuais;
    }

    public String getGeolocalizacao() {
        return geolocalizacao;
    }

    public void setGeolocalizacao(String geolocalizacao) {
        this.geolocalizacao = geolocalizacao;
    }


    /*@Override
    public String toString() {
        return "Filial{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cidade='" + cidade + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", visitasMensais=" + visitasMensais +
                ", visitasAnuais=" + visitasAnuais +
                ", geolocalizacao='" + geolocalizacao + '\'' +
                '}';
    }*/

    public int calcularSomaVisitasMensais() {
        int soma = 0;
        for (int visita : visitasMensais) {
            soma += visita;
        }
        return soma;
    }

    // Método para calcular a média das visitas mensais
    public double calcularMediaVisitasMensais() {
        if (visitasMensais.isEmpty()) {
            return 0;
        }
        int soma = calcularSomaVisitasMensais();
        return (double) soma / visitasMensais.size();
    }
    @Override
    public String toString() {
        return "Filial{" +
                "nome='" + nome + '\'' +
                ", média de visitas mensais=" + calcularMediaVisitasMensais() +
                ", soma de visitas mensais=" + calcularSomaVisitasMensais() +
                ", visitas anuais=" + visitasAnuais +
                '}';
    }
}
