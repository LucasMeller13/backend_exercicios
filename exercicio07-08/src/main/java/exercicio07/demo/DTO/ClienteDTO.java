package exercicio07.demo.DTO;

import javax.validation.constraints.NotNull;

public class ClienteDTO {
    @NotNull
    private String nome;
    @NotNull
    private Double saldo;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Double getSaldo() { return saldo; }
    public void setSaldo(Double saldo) { this.saldo = saldo; }
}
