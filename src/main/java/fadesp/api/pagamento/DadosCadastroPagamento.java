package fadesp.api.pagamento;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPagamento(
        @NotBlank
        String codigoDebito ,
        @NotBlank
        String cpfCnpj,
        @NotNull
        MetodoPagamento metodoPagamento,
        String numeroCartao,
        @NotBlank
        String valorPagamento,
        @NotNull
        StatusPagamento status
) {
}
