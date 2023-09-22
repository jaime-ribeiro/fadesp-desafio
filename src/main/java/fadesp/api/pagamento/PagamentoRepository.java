package fadesp.api.pagamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    List<PagamentoResponse> findByStatus(StatusPagamento status);
    List<PagamentoResponse> findByCpfCnpj(String cpfCnpj);
    List<PagamentoResponse> findByCodigoDebito(String codigoDebito);

}
