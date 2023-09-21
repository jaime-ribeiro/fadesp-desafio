package fadesp.api.pagamento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarStatusPagamento(
        @NotNull
        String status
) {
}
