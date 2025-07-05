package br.com.alura.TabelaFipeApplication.service;

import br.com.alura.TabelaFipeApplication.model.Marcas;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class AnoService {
    private final Scanner scanner;
    private final String tipoVeiculo;
    private final String codigoMarca;
    private final String codigoModelo;
    private final ConsumoAPI api = new ConsumoAPI();

    public AnoService(Scanner scanner, String tipoVeiculo, String codigoMarca, String codigoModelo) {
        this.scanner = scanner;
        this.tipoVeiculo = tipoVeiculo;
        this.codigoMarca = codigoMarca;
        this.codigoModelo = codigoModelo;
    }

    public Marcas selecionarAno() {
        Marcas[] anos = api.getAnos(tipoVeiculo, codigoMarca, codigoModelo);
        if (anos.length == 0) {
            System.out.println("❌ Nenhum ano encontrado.");
            return null;
        }

        Arrays.stream(anos)
                .forEach(ano -> System.out.println(ano.codigo() + " - " + ano.nome()));

        while (true) {
            System.out.print("\nDigite o código do ano desejado: ");
            String entrada = scanner.nextLine().toLowerCase();

            if (entrada.equals("sair")) {
                System.out.println("Encerrando.");
                return null;
            }

            Optional<Marcas> selecionado = Arrays.stream(anos)
                    .filter(ano -> String.valueOf(ano.codigo()).equalsIgnoreCase(entrada))
                    .findFirst();

            if (selecionado.isPresent()) {
                return selecionado.get();
            } else {
                System.out.println("❌ Ano não encontrado. Tente novamente.");
            }
        }
    }
}
