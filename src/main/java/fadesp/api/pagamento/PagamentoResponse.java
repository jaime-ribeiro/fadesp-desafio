package fadesp.api.pagamento;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class PagamentoResponse {
    private String codigoDebito;
    private String cpfCnpj;
    @Enumerated(EnumType.STRING)
    private MetodoPagamento metodoPagamento;
    private String numeroCartao;
    private String valorPagamento;
    private StatusPagamento status;

    public PagamentoResponse(Pagamento pagamento){
        this.codigoDebito = pagamento.getCodigoDebito();
        this.cpfCnpj = pagamento.getCpfCnpj();
        this.metodoPagamento = pagamento.getMetodoPagamento();
        this.numeroCartao = pagamento.getNumeroCartao();
        this.valorPagamento = pagamento.getValorPagamento();
        this.status = pagamento.getStatus();
    }
    public String getCodigoDebito() {
        return codigoDebito;
    }

    public void setCodigoDebito(String codigoDebito) {
        this.codigoDebito = codigoDebito;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(String valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }
}
