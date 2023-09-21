package fadesp.api.pagamento;

import jakarta.validation.constraints.NotNull;

public record DadosApagarPagamento(
        @NotNull
        String status
) {
}
