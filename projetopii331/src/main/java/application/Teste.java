/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

/**
 *
 * @author Marcos Gabriel Soares Cruz  <marcossetecruzsoares@gmail.com>
 */


import entities.Csv;
import entities.Municipio;
import entities.MunicipioServico;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Csv csv = new Csv();
        MunicipioServico municipioService = null;

        try {
            List<Municipio> municipios = csv.lerCsv("C:\\Users\\marco\\Documents\\NetBeansProjects\\Projeto Integrador\\Entrada\\01.ProjetoIntegrador_BaseMunicipios_In - 01.ProjetoIntegrador_BaseMunicipios_In.csv");
            municipioService = new MunicipioServico(municipios);
            municipioService.calcularInformacoes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("Escolha uma operação: 1-Listar 2-Criar 3-Atualizar 4-Excluir 5-Salvar 6-Mostrar Melhor/Pior PIBpC e IDH Educação 7-Sair");
                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consumir nova linha

                switch (opcao) {
                    case 1:
                        for (Municipio municipio : municipioService.listarMunicipios()) {
                            System.out.println(municipio);
                        }
                        break;

                    case 2:
                        System.out.println("Digite os dados do novo município (separados por vírgula):");
                    String[] dados = scanner.nextLine().split(",");
                    String codigoIBGENovo = dados[0];
                    if (municipioService.buscarMunicipioPorCodigo(codigoIBGENovo) != null) {
                        System.out.println("Código IBGE já existente. Não é possível adicionar o município.");
                        break;
                    }
                    Municipio novoMunicipio = new Municipio(dados[0], dados[1], dados[2], dados[3], dados[4],
                            Double.parseDouble(dados[5]), Double.parseDouble(dados[6]), Double.parseDouble(dados[7]),
                            Double.parseDouble(dados[8]), Double.parseDouble(dados[9]), Double.parseDouble(dados[10]),
                            Double.parseDouble(dados[11]), Double.parseDouble(dados[12]), Double.parseDouble(dados[13]),
                            Double.parseDouble(dados[14]));
                    municipioService.adicionarMunicipio(novoMunicipio);
                    System.out.println("Município adicionado com sucesso.");
                    break;

                    case 3:
                        System.out.println("Digite o código IBGE do município a ser atualizado:");
                        String codigoIBGE = scanner.nextLine();
                        Municipio municipioExistente = municipioService.buscarMunicipioPorCodigo(codigoIBGE);
                        if (municipioExistente == null) {
                            System.out.println("Código IBGE não encontrado. Por favor, tente novamente.");
                            break;
                        }
                        System.out.println("Digite os novos dados do município (separados por vírgula):");
                        String[] novosDados = scanner.nextLine().split(",");
                        Municipio municipioAtualizado = new Municipio(novosDados[0], novosDados[1], novosDados[2], novosDados[3], novosDados[4],
                                Double.parseDouble(novosDados[5]), Double.parseDouble(novosDados[6]), Double.parseDouble(novosDados[7]),
                                Double.parseDouble(novosDados[8]), Double.parseDouble(novosDados[9]), Double.parseDouble(novosDados[10]),
                                Double.parseDouble(novosDados[11]), Double.parseDouble(novosDados[12]), Double.parseDouble(novosDados[13]),
                                Double.parseDouble(novosDados[14]));
                        municipioService.atualizarMunicipio(codigoIBGE, municipioAtualizado);
                        System.out.println("Município atualizado: " + municipioService.listarMunicipios().stream()
                                .filter(m -> m.getCodigoIBGE().equals(codigoIBGE)).findFirst().orElse(null).formatarInfo());
                        break;

                    case 4:
                        System.out.println("Digite o código IBGE do município a ser excluído:");
                        String codigoExclusao = scanner.nextLine();
                        Municipio municipioParaExcluir = municipioService.buscarMunicipioPorCodigo(codigoExclusao);
                        if (municipioParaExcluir == null) {
                            System.out.println("Código IBGE não encontrado. Por favor, tente novamente.");
                            break;
                        }
                        municipioService.excluirMunicipio(codigoExclusao);
                        System.out.println("Município excluído com sucesso.");
                        break;

                    case 5:
                        try {
                            csv.escreverCsv(municipioService.listarMunicipios(), "C:\\Users\\marco\\Documents\\Novo modelo\\01.ProjetoIntegrador_BaseMunicipios_Out.csv");
                            System.out.println("Arquivo salvo com sucesso.");
                        } catch (IOException e) {
                            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
                            e.printStackTrace();
                        }
                        break;

                    case 6:
                        Municipio melhorPIBpC = municipioService.getMunicipioComMelhorPIBpC();
                        Municipio piorPIBpC = municipioService.getMunicipioComPiorPIBpC();
                        Municipio melhorIDHEducacao = municipioService.getMunicipioComMelhorIDHEducacao();
                        Municipio piorIDHEducacao = municipioService.getMunicipioComPiorIDHEducacao();

                        System.out.println("Melhor PIB per Capita:");
                        System.out.println(melhorPIBpC.formatarInfo());

                        System.out.println("\nPior PIB per Capita:");
                        System.out.println(piorPIBpC.formatarInfo());

                        System.out.println("\nMelhor IDH Educação:");
                        System.out.println(melhorIDHEducacao.formatarInfo());

                        System.out.println("\nPior IDH Educação:");
                        System.out.println(piorIDHEducacao.formatarInfo());
                        break;

                    case 7: 
                        continuar = false;
                        break;

                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next();  // Consumir a entrada inválida
            }
        }

        scanner.close();
    }
}