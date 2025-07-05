package br.com.alura.TabelaFipeApplication.service;

import br.com.alura.TabelaFipeApplication.model.Marcas;
import br.com.alura.TabelaFipeApplication.model.Modelos;
import br.com.alura.TabelaFipeApplication.model.Veiculo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class ConsumoAPI {
    private final ObjectMapper mapper = new ObjectMapper();

    public Marcas[] getMarcas(String tipoVeiculo) {
        var json = obterDados("https://parallelum.com.br/fipe/api/v1/" + tipoVeiculo + "/marcas");
        try {
            return mapper.readValue(json, Marcas[].class);
        } catch (Exception e) {
            return new Marcas[0];
        }
    }

    public Modelos getModelos(String tipoVeiculo, String codigoMarca) {
        var json = obterDados("https://parallelum.com.br/fipe/api/v1/" + tipoVeiculo + "/marcas/" + codigoMarca + "/modelos");
        try {
            return mapper.readValue(json, Modelos.class);
        } catch (Exception e) {
            return new Modelos(new ArrayList<>());
        }
    }

    public Marcas[] getAnos(String tipoVeiculo, String codigoMarca, String codigoModelo) {
        var json = obterDados("https://parallelum.com.br/fipe/api/v1/" + tipoVeiculo + "/marcas/" + codigoMarca + "/modelos/" + codigoModelo + "/anos");
        try {
            return mapper.readValue(json, Marcas[].class);
        } catch (Exception e) {
            return new Marcas[0];
        }
    }

    public Veiculo getDetalhes(String tipoVeiculo, String codigoMarca, String codigoModelo, String codigoAno) {
        var json = obterDados("https://parallelum.com.br/fipe/api/v1/" + tipoVeiculo + "/marcas/" + codigoMarca + "/modelos/" + codigoModelo + "/anos/" + codigoAno);
        try {
            return mapper.readValue(json, Veiculo.class);
        } catch (Exception e) {
            return null;
        }
    }

    public String obterDados(String endereco) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String json = response.body();
        return json;
    }
}
