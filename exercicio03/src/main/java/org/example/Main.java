package org.example;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Filme filme1 = new Filme("Filme 1", "action1", true, (short) 1);
        Filme filme2 = new Filme("Filme 2", "action2", false, (short) 1);
        Filme filme3 = new Filme("Filme 3", "action3", true, (short) 2);

        Ator ator1 = new Ator("Ator 1", "bras1", true, (short) 1);
        Ator ator2 = new Ator("Ator 2", "bras2", false, (short) 1);
        Ator ator3 = new Ator("Ator 3", "bras3", true, (short) 1);

        OscarService oscarService = new OscarService();

        oscarService.adicionarIndicacao(filme1, "Melhor Filme");
        oscarService.adicionarIndicacao(filme2, "Melhor Filme");
        oscarService.adicionarIndicacao(filme3, "Melhor Filme");

        oscarService.adicionarIndicacao(ator1, "Melhor Ator");
        oscarService.adicionarIndicacao(ator2, "Melhor Ator");
        oscarService.adicionarIndicacao(ator3, "Melhor Ator");

        ArrayList<Indicacao> indicados = oscarService.getIndicacoes();

        System.out.println("");

        for (Indicacao indicacao : indicados) {
            System.out.println(indicacao.getIndicavel().getClass().getSimpleName() + ": " +
                    indicacao.getIndicavel().getNumeroDeIndicacoes()+ " indicações em " +
                    indicacao.getCategoria());
        }

    }
}