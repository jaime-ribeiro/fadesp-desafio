package fadesp.api.controller;


import fadesp.api.pagamento.DadosAtualizarStatusPagamento;
import fadesp.api.pagamento.DadosCadastroPagamento;
import fadesp.api.pagamento.Pagamento;
import fadesp.api.pagamento.PagamentoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoRepository repository;
    @PostMapping
    @Transactional
    public void cadastrarPagamento(@RequestBody @Valid DadosCadastroPagamento dados) {
        repository.save(new Pagamento(dados));
    }

    @GetMapping
    public List<Pagamento> listarPagamentos() {
        return repository.findAll();
    }
    @GetMapping("/filtrar")
    public List<Pagamento> filtrarPagamentos(
            @RequestParam(value = "codigo_debito", required = false) String codigo_debito,
            @RequestParam(value = "cpf_cnpj", required = false) String cpf_cnpj,
            @RequestParam(value = "status" ,required = false) String status
    ) {
        return repository.findByCodigoDebito(codigo_debito);
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizarStatus(@PathVariable Long id, @RequestBody @Valid DadosAtualizarStatusPagamento dados){
        var pagamento = repository.getReferenceById(id);
        pagamento.atualizarStatus(dados);
    }
}
