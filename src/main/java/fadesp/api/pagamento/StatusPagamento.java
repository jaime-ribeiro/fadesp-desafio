package fadesp.api.pagamento;

public enum StatusPagamento {
    PENDENTE_DE_PROCESSAMENTO("PENDENTE_DE_PROCESSAMENTO"), PROCESSADO_COM_SUCESSO("PROCESSADO_COM_SUCESSO"), PROCESSADO_COM_FALHA("PROCESSADO_COM_FALHA");

    StatusPagamento(String processamento) {
    }
}