package fadesp.api.pagamento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    List<Pagamento> findByCodigoDebito(String codigoDebito);
}
