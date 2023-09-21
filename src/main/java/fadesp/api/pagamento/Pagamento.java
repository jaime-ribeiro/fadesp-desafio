package fadesp.api.pagamento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pagamentos")
@Entity(name = "Pagamento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pagamento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo_debito;
    private String cpf_cnpj;
    @Enumerated(EnumType.STRING)
    private MetodoPagamento metodo_pagamento;
    private String numero_cartao;
    private String valor_pagamento;
    private String status;

    public Pagamento(DadosCadastroPagamento dados){
        this.codigo_debito = dados.codigoDebito();
        this.metodo_pagamento = dados.metodoPagamento();
        this.valor_pagamento = dados.valorPagamento();
        this.cpf_cnpj = dados.cpfCnpj();
        this.numero_cartao = dados.numeroCartao();
        this.status = "PENDENTE_DE_PROCESSAMENTO";
    }

    public void atualizarStatus(DadosAtualizarStatusPagamento dados) {
        if(dados.status() != null)
            this.status = dados.status();
    }
}
