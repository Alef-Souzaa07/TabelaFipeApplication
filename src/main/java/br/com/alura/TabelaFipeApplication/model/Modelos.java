package br.com.alura.TabelaFipeApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Modelos (List<Marcas> modelos) {}