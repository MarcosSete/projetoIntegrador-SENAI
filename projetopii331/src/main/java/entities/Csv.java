/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Marcos Gabriel Soares Cruz  <marcossetecruzsoares@gmail.com>
 */


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Csv {

    public List<Municipio> lerCsv(String caminhoArquivo) throws IOException {
        List<Municipio> municipios = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo));
        String linha;
        br.readLine(); // Pular o cabeçalho

        while ((linha = br.readLine()) != null) {
            String[] dados = linha.split(",");
            Municipio municipio = new Municipio(dados[0], dados[1], dados[2], dados[3], dados[4],
                    Double.parseDouble(dados[5]), Double.parseDouble(dados[6]), Double.parseDouble(dados[7]),
                    Double.parseDouble(dados[8]), Double.parseDouble(dados[9]), Double.parseDouble(dados[10]),
                    Double.parseDouble(dados[11]), Double.parseDouble(dados[12]), Double.parseDouble(dados[13]),
                    Double.parseDouble(dados[14]));
            municipios.add(municipio);
        }
        br.close();
        return municipios;
    }

    public void escreverCsv(List<Municipio> municipios, String caminhoArquivo) throws IOException {
        // Certificar-se de que a pasta de destino existe
        String diretorio = caminhoArquivo.substring(0, caminhoArquivo.lastIndexOf(File.separator));
        if (!Files.exists(Paths.get(diretorio))) {
            Files.createDirectories(Paths.get(diretorio));
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo));
        bw.write("Código IBGE,Município,Microrregião,Estado,Região Geográfica,Área km2,População,Domicílios," +
                "PIB Total (R$ mil),IDH,Renda Média,Renda Nominal,PEA Dia,IDH Dimensão Educação," +
                "IDH Dimensão Longevidade,Densidade Demográfica,PIB per Capita,Classificação IDH," +
                "Classificação IDH Educação,Classificação IDH Longevidade,Última Atualização\n");

        for (Municipio municipio : municipios) {
            bw.write(municipio.toString() + "\n");
        }

        bw.close();
    }
}
