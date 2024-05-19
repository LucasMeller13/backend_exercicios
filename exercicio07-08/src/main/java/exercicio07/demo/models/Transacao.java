package exercicio07.demo.models;

import javax.validation.constraints.NotNull;

public class Transacao {

    @NotNull
    private String recebedor;
    @NotNull
    private String pagador;
    @NotNull
    private Double quantidade;

    public String getRecebedor() { return recebedor; }
    public void setRecebedor(String recebedor) { this.recebedor = recebedor; }

    public String getPagador() { return pagador; }
    public void setPagador(String pagador) { this.pagador = pagador; }

    public Double getQuantidade() { return quantidade; }
    public void setQuantidade(Double quantidade) { this.quantidade = quantidade; }
}
