package br.com.alura.TabelaFipeApplication.service;

import br.com.alura.TabelaFipeApplication.model.Veiculo;

public class VeiculoService {
    private final String tipoVeiculo, codigoMarca, codigoModelo, codigoAno;
    private final ConsumoAPI api = new ConsumoAPI();

    public VeiculoService(String tipoVeiculo, String codigoMarca, String codigoModelo, String codigoAno) {
        this.tipoVeiculo = tipoVeiculo;
        this.codigoMarca = codigoMarca;
        this.codigoModelo = codigoModelo;
        this.codigoAno = codigoAno;
    }

    public void exibirDetalhes() {
        Veiculo veiculo = api.getDetalhes(tipoVeiculo, codigoMarca, codigoModelo, codigoAno);

        System.out.println("\n********** Detalhes do Veículo **********");
        System.out.println("Marca: " + veiculo.Marca());
        System.out.println("Modelo: " + veiculo.Modelo());
        System.out.println("Ano: " + veiculo.AnoModelo());
        System.out.println("Combustível: " + veiculo.Combustivel());
        System.out.println("Código FIPE: " + veiculo.CodigoFipe());
        System.out.println("Mês de Referência: " + veiculo.MesReferencia());
        System.out.println("Valor: " + veiculo.Valor());
    }
}
