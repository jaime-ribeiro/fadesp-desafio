package fadesp.api.pagamento;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    List<Pagamento> findByStatus(String status);
    List<Pagamento> findByCpfCnpj(String cpfCnpj);
    List<Pagamento> findByCodigoDebito(String codigoDebito);
    //List<Pagamento> findById(Long id);
}
