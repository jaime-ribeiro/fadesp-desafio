package fadesp.api.controller;


import fadesp.api.pagamento.DadosAtualizarStatusPagamento;
import fadesp.api.pagamento.DadosCadastroPagamento;
import fadesp.api.pagamento.Pagamento;
import fadesp.api.pagamento.PagamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/status")
    public List<Pagamento> listarStatusPagamentos(
            @RequestParam(value = "status" ) String status
    ) {
        return repository.findByStatus(status);
    }

    @GetMapping("/codigoDebito")

    public List<Pagamento> ListarCodigoDebitoPagamentos(
            @RequestParam(value = "codigoDebito") String codigoDebito
    ) {
        return repository.findByCodigoDebito(codigoDebito);
    }

    @GetMapping("/cpfCnpj")
    public List<Pagamento> ListarCpfCnpjPagamentos(
            @RequestParam(value = "cpfCnpj") String cpfCnpj
    ) {
        return repository.findByCpfCnpj(cpfCnpj);
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizarStatus(@PathVariable Long id, @RequestBody @Valid DadosAtualizarStatusPagamento dados){
        var pagamento = repository.getReferenceById(id);
        pagamento.atualizarStatus(dados);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> apagarPagamento(@PathVariable Long id){
        Optional<Pagamento>optionalPagamento = repository.findById(id);
        if(optionalPagamento.isPresent()){
            Pagamento pagamento = optionalPagamento.get();
            var status = pagamento.getStatus();
            if(status.equals("PENDENTE_DE_PROCESSAMENTO")){
                repository.deleteById(id);
                return new ResponseEntity<>("OK", HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("O STATUS PRECISA SER PENDENTE_DE_PROCESSAMENTO PARA SER APAGADO", HttpStatus.FORBIDDEN);
            }
        }else {
            return new ResponseEntity<>("ERRO, PAGAMENTO NÃO ENCONTRADO", HttpStatus.NOT_FOUND);
        }
    }
}


