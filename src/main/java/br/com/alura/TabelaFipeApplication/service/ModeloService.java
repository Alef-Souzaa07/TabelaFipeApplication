package br.com.alura.TabelaFipeApplication.service;

import br.com.alura.TabelaFipeApplication.model.Marcas;
import br.com.alura.TabelaFipeApplication.model.Modelos;

import java.util.Optional;
import java.util.Scanner;

public class ModeloService {
    private final Scanner scanner;
    private final String tipoVeiculo;
    private final String codigoMarca;
    private final ConsumoAPI api = new ConsumoAPI();

    public ModeloService(Scanner scanner, String tipoVeiculo, String codigoMarca) {
        this.scanner = scanner;
        this.tipoVeiculo = tipoVeiculo;
        this.codigoMarca = codigoMarca;
    }

    public Marcas selecionarModelo() {
        Modelos modelos = api.getModelos(tipoVeiculo, codigoMarca);
        if (modelos.modelos().isEmpty()) {
            System.out.println("❌ Nenhum modelo encontrado.");
            return null;
        }

        modelos.modelos()
                .forEach(modelo -> System.out.println(modelo.codigo() + " - " + modelo.nome()));

        while (true) {
            System.out.print("\nDigite o código do modelo desejado: ");
            String entrada = scanner.nextLine().toLowerCase();

            if (entrada.equals("sair")) {
                System.out.println("Encerrando.");
                return null;
            }

            Optional<Marcas> selecionado = modelos.modelos().stream()
                    .filter(modelo -> String.valueOf(modelo.codigo()).equalsIgnoreCase(entrada) ||
                            modelo.nome().toLowerCase().contains(entrada))
                    .findFirst();

            if (selecionado.isPresent()) {
                return selecionado.get();
            } else {
                System.out.println("❌ Modelo não encontrado. Tente novamente.");
            }
        }
    }
}
