package fadesp.api.pagamento;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "pagamentos")
@Entity(name = "Pagamento")
@Getter
@Setter
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
    private String status;

    public Pagamento(DadosCadastroPagamento dados){
        this.codigoDebito = dados.codigoDebito();
        this.metodoPagamento = dados.metodoPagamento();
        this.valorPagamento = dados.valorPagamento();
        this.cpfCnpj = dados.cpfCnpj();
        this.numeroCartao = dados.numeroCartao();
        this.status = "PENDENTE_DE_PROCESSAMENTO";
    }

    public void atualizarStatus(DadosAtualizarStatusPagamento dados) {
        if(dados.status() != null)
            this.status = dados.status();
    }

    public String getStatus() {
        return status;
    }
}
