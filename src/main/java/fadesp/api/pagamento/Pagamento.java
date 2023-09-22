package fadesp.api.pagamento;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "pagamentos")
@Entity(name = "Pagamento")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pagamento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigoDebito;
    private String cpfCnpj;
    @Enumerated(EnumType.STRING)
    private MetodoPagamento metodoPagamento;
    private String numeroCartao;
    private String valorPagamento;
    @Enumerated(EnumType.STRING)
    private StatusPagamento status;

    public Pagamento(PagamentoDTO dados){
        this.codigoDebito = dados.getCodigoDebito();
        this.metodoPagamento = dados.getMetodoPagamento();
        this.valorPagamento = dados.getValorPagamento();
        this.cpfCnpj = dados.getCpfCnpj();
        this.numeroCartao = dados.getNumeroCartao();
        this.status = dados.getStatusPagamento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
