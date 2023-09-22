package fadesp.api.controller;


import fadesp.api.pagamento.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pagamentos")
public class PagamentoController {

    //@Autowired
    //private PagamentoService PagamentoService;
    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping
    @Transactional
    public PagamentoResponse cadastrarPagamento(@RequestBody @Valid PagamentoDTO pagamentoDTO) {
        return pagamentoService.criarPagamento(pagamentoDTO);
    }
    @GetMapping
    public List<Pagamento> listarPagamentos() {
        return pagamentoService.buscarPagamentos();
    }
    @GetMapping("/status/{status}")
    public List<PagamentoResponse> listarStatusPagamentos(@PathVariable StatusPagamento status) {
        return pagamentoService.buscarPagamentoStatus(status);
    }

    @GetMapping("/codigoDebito/{codigoDebito}")

    public List<PagamentoResponse> ListarCodigoDebitoPagamentos(@PathVariable String codigoDebito) {
        return pagamentoService.buscarPagamentoCodigoDebito(codigoDebito);
    }

    @GetMapping("/cpfCnpj/{cpfCpnj}")
    public List<PagamentoResponse> ListarCpfCnpjPagamentos(@PathVariable String cpfCnpj) {
        return pagamentoService.buscarPagamentoCpfCnpj(cpfCnpj);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> atualizarStatus(@PathVariable Long id, @RequestBody @Valid NovoStatusPagamento statusPagamento){
        if(pagamentoService.alterarPagamento(id, statusPagamento).equals("OK")){
            return new ResponseEntity<>("OK", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("ERRO, PAGAMENTO NÃO ENCONTRADO", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> apagarPagamento(@PathVariable Long id){
        if(pagamentoService.excluirPagamento(id).equals("OK")){
            return new ResponseEntity<>("OK", HttpStatus.OK);
        }else if(pagamentoService.excluirPagamento(id).equals("FORBIDDEN")){
            return new ResponseEntity<>("O STATUS PRECISA SER PENDENTE_DE_PROCESSAMENTO PARA SER APAGADO", HttpStatus.FORBIDDEN);
        }else {
            return new ResponseEntity<>("ERRO, PAGAMENTO NÃO ENCONTRADO", HttpStatus.NOT_FOUND);
        }
    }
}


