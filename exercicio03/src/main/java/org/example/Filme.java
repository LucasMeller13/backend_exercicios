package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Filme implements Indicavel{
    private String nome;
    private String genero;
    private boolean elegivel;
    private short numeroDeIndicacoes;

    public Filme(String nome, String genero, boolean elegivel, short numeroDeIndicacoes){
        this.nome = nome;
        this.genero = genero;
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
