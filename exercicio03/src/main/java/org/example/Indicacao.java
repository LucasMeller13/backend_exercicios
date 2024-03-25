package org.example;

import org.springframework.stereotype.Component;

@Component
public class Indicacao{
    private Indicavel indicavel;
    private String categoria;

    public Indicacao(Indicavel indicavel, String categoria){
        this.indicavel = indicavel;
        this.categoria = categoria;
    }

    public Indicavel getIndicavel() {
        return indicavel;
    }

    public void setIndicavel(Indicavel indicavel) {
        this.indicavel = indicavel;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
