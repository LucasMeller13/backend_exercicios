package exercicio07.demo.DTO;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TransacaoDTO {
    @NotNull
    private String recebedor;
    @NotNull
    private String pagador;

    @NotNull
    @Max(value = 10000, message = "Dinheiro a ser transferido tem que ser menor que dez mil reais.")
    @Min(value = 0, message = "Dinheiro a ser transferido tem que ser maior que zero reais.")
    private Double quantidade;

    public String getRecebedor() { return recebedor; }
    public void setRecebedor(String recebedor) { this.recebedor = recebedor; }

    public String getPagador() { return pagador; }
    public void setPagador(String pagador) { this.pagador = pagador; }

    public Double getQuantidade() { return quantidade; }
    public void setQuantidade(Double quantidade) { this.quantidade = quantidade; }
}
