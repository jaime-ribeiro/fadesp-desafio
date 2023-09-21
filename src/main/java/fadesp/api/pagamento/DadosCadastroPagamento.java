package fadesp.api.pagamento;

public record DadosCadastroPagamento(String codigoDebito ,String cpfCnpj, MetodoPagamento metodoPagamento, String numeroCartao, String valorPagamento) {
}
