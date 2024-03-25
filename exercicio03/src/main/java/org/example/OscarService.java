package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OscarService {
    private ArrayList<Indicacao> indicacoes = new ArrayList<>();

    public void adicionarIndicacao(Indicavel indicavel, String categoria){
        if (indicavel.isElegivel()) {
            indicavel.incrementarIndicacoes();
            indicacoes.add(new Indicacao(indicavel, categoria));
        } else {
            System.out.println("O filme ou ator não é elegível para indicação.");
        }
    }

    public ArrayList<Indicacao> getIndicacoes() {
        return indicacoes;
    }
}
