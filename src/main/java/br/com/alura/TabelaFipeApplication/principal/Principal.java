package br.com.alura.TabelaFipeApplication.principal;

import br.com.alura.TabelaFipeApplication.service.AnoService;
import br.com.alura.TabelaFipeApplication.service.MarcaService;
import br.com.alura.TabelaFipeApplication.service.ModeloService;
import br.com.alura.TabelaFipeApplication.service.VeiculoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.Scanner;

public class Principal {
    private final Scanner scanner = new Scanner(System.in);

    public void exibirMenu() throws JsonProcessingException {
        System.out.println("************************************************************");
        System.out.println("Escolha uma das opções abaixo:");
        System.out.println("1 - Carros");
        System.out.println("2 - Motos");
        System.out.println("3 - Caminhões");
        var escolha = scanner.nextLine().toLowerCase();

        String tipoVeiculo = switch (escolha) {
            case "1", "carros", "carro" -> "carros";
            case "2", "motos", "moto" -> "motos";
            case "3", "caminhoes", "caminhao", "caminhão" -> "caminhoes";
            default -> {
                System.out.println("❌ Opção inválida.");
                yield null;
            }
        };

        if (tipoVeiculo == null) return;

        var marcaService = new MarcaService(scanner, tipoVeiculo);
        var marca = marcaService.selecionarMarca();

        if (marca == null) return;

        var modeloService = new ModeloService(scanner, tipoVeiculo, marca.codigo());
        var modelo = modeloService.selecionarModelo();

        if (modelo == null) return;

        var anoService = new AnoService(scanner, tipoVeiculo, marca.codigo(), modelo.codigo());
        var ano = anoService.selecionarAno();

        if (ano == null) return;

        new VeiculoService(tipoVeiculo, marca.codigo(), modelo.codigo(), ano.codigo()).exibirDetalhes();
    }
}
