package br.com.alura.TabelaFipeApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Veiculo(String Marca,
                      String Modelo,
                      String Valor,
                      String Combustivel,
                      String CodigoFipe,
                      String MesReferencia,
                      Integer AnoModelo) {
}
