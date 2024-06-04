/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Marcos Gabriel Soares Cruz  <marcossetecruzsoares@gmail.com>
 */


import java.util.Comparator;
import java.util.List;

public class MunicipioServico {
    private List<Municipio> municipios;

    public MunicipioServico(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    public void calcularInformacoes() {
        for (Municipio municipio : municipios) {
            municipio.calcularDensidadeDemografica();
            municipio.calcularPibPerCapita();
            municipio.calcularClassificacoesIDH();
        }
    }

    public void atualizarMunicipio(String codigoIBGE, Municipio novosDados) {
    for (Municipio municipio : municipios) {
        if (municipio.getCodigoIBGE().equals(codigoIBGE)) {
            municipio.setMunicipio(novosDados.getMunicipio());
            municipio.setMicrorregiao(novosDados.getMicrorregiao());
            municipio.setEstado(novosDados.getEstado());
            municipio.setRegiaoGeografica(novosDados.getRegiaoGeografica());
            municipio.setArea(novosDados.getArea());
            municipio.setPopulacao(novosDados.getPopulacao());
            municipio.setDomicilios(novosDados.getDomicilios());
            municipio.setPibTotal(novosDados.getPibTotal());
            municipio.setIdh(novosDados.getIdh());
            municipio.setRendaMedia(novosDados.getRendaMedia());
            municipio.setRendaNominal(novosDados.getRendaNominal());
            municipio.setPeaDia(novosDados.getPeaDia());
            municipio.setIdhEducacao(novosDados.getIdhEducacao());
            municipio.setIdhLongevidade(novosDados.getIdhLongevidade());

            // Realiza todos os cálculos necessários
            municipio.calcularDensidadeDemografica();
            municipio.calcularPibPerCapita();
            municipio.calcularClassificacoesIDH();
            municipio.atualizarUltimaAtualizacao();

            // Adicione esta linha para debug
            System.out.println("Município atualizado: " + municipio.formatarInfo());
            break;
        }
    }
}


    public void excluirMunicipio(String codigoIBGE) {
        municipios.removeIf(municipio -> municipio.getCodigoIBGE().equals(codigoIBGE));
    }

    public Municipio buscarMunicipioPorCodigo(String codigoIBGE) {
        for (Municipio municipio : municipios) {
            if (municipio.getCodigoIBGE().equals(codigoIBGE)) {
                return municipio;
            }
        }
        return null;
    }

    public List<Municipio> listarMunicipios() {
        return municipios;
    }

    public void adicionarMunicipio(Municipio municipio) {
        municipios.add(municipio);
        calcularInformacoes();
    }
    
    // calculos de matemática
    public Municipio getMunicipioComMelhorPIBpC() {
        return municipios.stream().max(Comparator.comparing(Municipio::getPibPerCapita)).orElse(null);
    }

    public Municipio getMunicipioComPiorPIBpC() {
        return municipios.stream().min(Comparator.comparing(Municipio::getPibPerCapita)).orElse(null);
    }

    public Municipio getMunicipioComMelhorIDHEducacao() {
        return municipios.stream().max(Comparator.comparing(Municipio::getIdhEducacao)).orElse(null);
    }

    public Municipio getMunicipioComPiorIDHEducacao() {
        return municipios.stream().min(Comparator.comparing(Municipio::getIdhEducacao)).orElse(null);
    }
}
