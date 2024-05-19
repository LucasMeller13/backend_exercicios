package exercicio07.demo.models;

import javax.validation.constraints.NotNull;

public class Cliente {
    @NotNull
    private String nome;
    @NotNull
    private Double saldo;
    @NotNull
    private String senha;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Double getSaldo() { return saldo; }
    public void setSaldo(Double saldo) { this.saldo = saldo; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}
