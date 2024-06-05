/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Marcos Gabriel Soares Cruz  <marcossetecruzsoares@gmail.com>
 */



import java.text.SimpleDateFormat;
import java.util.Date;

public class Municipio {
    private String codigoIBGE;
    private String municipio;
    private String microrregiao;
    private String estado;
    private String regiaoGeografica;
    private double area;
    private double populacao;
    private double domicilios;
    private double pibTotal;
    private double idh;
    private double rendaMedia;
    private double rendaNominal;
    private double peaDia;
    private double idhEducacao;
    private double idhLongevidade;
    private double densidadeDemografica;
    private double pibPerCapita;
    private String classificacaoIDH;
    private String classificacaoIDHEducacao;
    private String classificacaoIDHLongevidade;
    private String ultimaAtualizacao;

    public Municipio(String codigoIBGE, String municipio, String microrregiao, String estado, String regiaoGeografica,
                     double area, double populacao, double domicilios, double pibTotal, double idh, double rendaMedia,
                     double rendaNominal, double peaDia, double idhEducacao, double idhLongevidade) {
        this.codigoIBGE = codigoIBGE;
        this.municipio = municipio;
        this.microrregiao = microrregiao;
        this.estado = estado;
        this.regiaoGeografica = regiaoGeografica;
        this.area = area;
        this.populacao = populacao;
        this.domicilios = domicilios;
        this.pibTotal = pibTotal;
        this.idh = idh;
        this.rendaMedia = rendaMedia;
        this.rendaNominal = rendaNominal;
        this.peaDia = peaDia;
        this.idhEducacao = idhEducacao;
        this.idhLongevidade = idhLongevidade;
        this.atualizarUltimaAtualizacao();
    }

    public String getCodigoIBGE() {
        return codigoIBGE;
    }

    public void setCodigoIBGE(String codigoIBGE) {
        this.codigoIBGE = codigoIBGE;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getMicrorregiao() {
        return microrregiao;
    }

    public void setMicrorregiao(String microrregiao) {
        this.microrregiao = microrregiao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRegiaoGeografica() {
        return regiaoGeografica;
    }

    public void setRegiaoGeografica(String regiaoGeografica) {
        this.regiaoGeografica = regiaoGeografica;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPopulacao() {
        return populacao;
    }

    public void setPopulacao(double populacao) {
        this.populacao = populacao;
    }

    public double getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(double domicilios) {
        this.domicilios = domicilios;
    }

    public double getPibTotal() {
        return pibTotal;
    }

    public void setPibTotal(double pibTotal) {
        this.pibTotal = pibTotal;
    }

    public double getIdh() {
        return idh;
    }

    public void setIdh(double idh) {
        this.idh = idh;
    }

    public double getRendaMedia() {
        return rendaMedia;
    }

    public void setRendaMedia(double rendaMedia) {
        this.rendaMedia = rendaMedia;
    }

    public double getRendaNominal() {
        return rendaNominal;
    }

    public void setRendaNominal(double rendaNominal) {
        this.rendaNominal = rendaNominal;
    }

    public double getPeaDia() {
        return peaDia;
    }

    public void setPeaDia(double peaDia) {
        this.peaDia = peaDia;
    }

    public double getIdhEducacao() {
        return idhEducacao;
    }

    public void setIdhEducacao(double idhEducacao) {
        this.idhEducacao = idhEducacao;
    }

    public double getIdhLongevidade() {
        return idhLongevidade;
    }

    public void setIdhLongevidade(double idhLongevidade) {
        this.idhLongevidade = idhLongevidade;
    }

    public double getDensidadeDemografica() {
        return densidadeDemografica;
    }

    public void setDensidadeDemografica(double densidadeDemografica) {
        this.densidadeDemografica = densidadeDemografica;
    }

    public double getPibPerCapita() {
        return pibPerCapita;
    }

    public void setPibPerCapita(double pibPerCapita) {
        this.pibPerCapita = pibPerCapita;
    }

    public String getClassificacaoIDH() {
        return classificacaoIDH;
    }

    public void setClassificacaoIDH(String classificacaoIDH) {
        this.classificacaoIDH = classificacaoIDH;
    }

    public String getClassificacaoIDHEducacao() {
        return classificacaoIDHEducacao;
    }

    public void setClassificacaoIDHEducacao(String classificacaoIDHEducacao) {
        this.classificacaoIDHEducacao = classificacaoIDHEducacao;
    }

    public String getClassificacaoIDHLongevidade() {
        return classificacaoIDHLongevidade;
    }

    public void setClassificacaoIDHLongevidade(String classificacaoIDHLongevidade) {
        this.classificacaoIDHLongevidade = classificacaoIDHLongevidade;
    }

    public String getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(String ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    // Métodos adicionais para calcular densidade demográfica, PIB per capita e classificações IDH
    public void calcularDensidadeDemografica() {
        this.densidadeDemografica = this.populacao / this.area;
    }

    public void calcularPibPerCapita() {
        this.pibPerCapita = this.pibTotal / this.populacao;
    }

    public void calcularClassificacoesIDH() {
        this.classificacaoIDH = classificarIDH(this.idh);
        this.classificacaoIDHEducacao = classificarIDH(this.idhEducacao);
        this.classificacaoIDHLongevidade = classificarIDH(this.idhLongevidade);
    }

    private String classificarIDH(double idh) {
        if (idh > 0.80) {
            return "Muito alto";
        } else if (idh > 0.70) {
            return "Alto";
        } else if (idh > 0.55) {
            return "Médio";
        } else {
            return "Baixo";
        }
    }

    public void atualizarUltimaAtualizacao() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.ultimaAtualizacao = sdf.format(new Date());
    }

    @Override
    public String toString() {
        return "codigoIBGE: "+codigoIBGE + " , " + "municipio: "+municipio + " , " +"microrregiao: "+microrregiao + " , " +"estado: "+ estado + " , " + "regiaoGeografica: "+regiaoGeografica + " , " +
                "area: "+area + " , " +"populacao: "+ populacao + " , " +"domicilios: "+ domicilios + " , " +"pibTotal: "+ pibTotal + " , " + "idh: "+idh + " , " + "rendaMedia"+rendaMedia + " , " +
                "rendaNominal: "+rendaNominal + " , " + "peaDia: "+peaDia + " , " +"idhEducacao: "+ idhEducacao + " , " + "idhLongevidade: "+idhLongevidade + " , " +
                "densidadeDemografica: "+densidadeDemografica + " , " + "pibPerCapita: "+pibPerCapita + " , " + "classificacaoIDH: "+classificacaoIDH + " , " +
                "classificacaoIDHEducacao: "+classificacaoIDHEducacao + " , " + "classificacaoIDHLongevidade: "+ classificacaoIDHLongevidade + " , " +"ultimaAtualizacao: "+ ultimaAtualizacao;
    }
    
    
    public String formatarInfo() {
    return String.format(
        "Código IBGE: %s\n" +
        "Município: %s\n" +
        "Microrregião: %s\n" +
        "Estado: %s\n" +
        "Região Geográfica: %s\n" +
        "Área: %.2f km²\n" +
        "População: %.0f\n" +
        "Domicílios: %.2f\n" +
        "PIB Total: %.2f\n" +
        "IDH: %.3f\n" +
        "Renda Média: %.5f\n" +
        "Renda Nominal: %.2f\n" +
        "PEA Dia: %.2f\n" +
        "IDH Educação: %.3f\n" +
        "IDH Longevidade: %.3f\n" +
        "Densidade Demográfica: %.2f\n" +
        "PIB per Capita: %.2f\n" +
        "Classificação IDH: %s\n" +
        "Classificação IDH Educação: %s\n" +
        "Classificação IDH Longevidade: %s\n" +
        "Última Atualização: %s",
        codigoIBGE, municipio, microrregiao, estado, regiaoGeografica, area, populacao, domicilios, pibTotal, idh,
        rendaMedia, rendaNominal, peaDia, idhEducacao, idhLongevidade, densidadeDemografica, pibPerCapita, 
        classificacaoIDH, classificacaoIDHEducacao, classificacaoIDHLongevidade, ultimaAtualizacao
    );
}

}
