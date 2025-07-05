package br.com.alura.TabelaFipeApplication;

import br.com.alura.TabelaFipeApplication.principal.Principal;
import br.com.alura.TabelaFipeApplication.service.ConsumoAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TabelaFipeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TabelaFipeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //System.out.println("Projeto desafio tabela fipe");
        try {
            new Principal().exibirMenu();
        } catch (Exception e) {
            System.out.println("Erro ao executar o sistema: " + e.getMessage());
        }
    }
}
