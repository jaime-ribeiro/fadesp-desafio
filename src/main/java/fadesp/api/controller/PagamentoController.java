package fadesp.api.controller;


import fadesp.api.pagamento.DadosCadastroPagamento;
import fadesp.api.pagamento.Pagamento;
import fadesp.api.pagamento.PagamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroPagamento dados) {
        repository.save(new Pagamento(dados));
    }
}
