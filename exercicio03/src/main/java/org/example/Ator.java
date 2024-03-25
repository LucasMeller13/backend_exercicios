package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Ator implements Indicavel{
    private String nome;
    private String nacionalidade;
    private boolean elegivel;
    private short numeroDeIndicacoes;

    public Ator(String nome, String nacionalidade, boolean elegivel, short numeroDeIndicacoes){
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.elegivel = elegivel;
        this.numeroDeIndicacoes = numeroDeIndicacoes;
    }

    @Override
    public boolean isElegivel() {
        return elegivel;
    }

    @Override
    public int getNumeroDeIndicacoes() {
        return numeroDeIndicacoes;
    }

    @Override
    public void incrementarIndicacoes() {
        numeroDeIndicacoes++;
    }

}
