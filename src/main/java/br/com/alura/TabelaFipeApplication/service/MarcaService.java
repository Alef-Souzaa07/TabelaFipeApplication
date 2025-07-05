package br.com.alura.TabelaFipeApplication.service;

import br.com.alura.TabelaFipeApplication.model.Marcas;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class MarcaService {
    private final Scanner scanner;
    private final String tipoVeiculo;
    private final ConsumoAPI api = new ConsumoAPI();

    public MarcaService(Scanner scanner, String tipoVeiculo) {
        this.scanner = scanner;
        this.tipoVeiculo = tipoVeiculo;
    }

    public Marcas selecionarMarca() {
        Marcas[] marcas = api.getMarcas(tipoVeiculo);
        if (marcas == null || marcas.length == 0) {
            System.out.println("❌ Nenhuma marca encontrada.");
            return null;
        }

        Arrays.stream(marcas)
                .forEach(marca -> System.out.println(marca.codigo() + " - " + marca.nome()));

        while (true) {
            System.out.print("\nDigite o código ou nome da marca desejada: ");
            String entrada = scanner.nextLine().toLowerCase();

            Optional<Marcas> selecionada = Arrays.stream(marcas)
                    .filter(marca -> String.valueOf(marca.codigo()).equalsIgnoreCase(entrada) ||
                            marca.nome().toLowerCase().contains(entrada))
                    .findFirst();

            if (selecionada.isPresent()) {
                return selecionada.get();
            } else {
                System.out.println("❌ Marca não encontrada. Tente novamente.");
            }
        }
    }
}
