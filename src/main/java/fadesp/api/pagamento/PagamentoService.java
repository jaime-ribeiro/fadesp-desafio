package fadesp.api.pagamento;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {
    private final PagamentoRepository pagamentoRepository;
    public PagamentoService(PagamentoRepository repository) {
        this.pagamentoRepository = repository;
    }


    public String excluirPagamento(Long id){
        Optional<Pagamento> optionalPagamento = pagamentoRepository.findById(id);
        if(optionalPagamento.isPresent()){
            Pagamento pagamento = optionalPagamento.get();
            var status = pagamento.getStatus();
            if(status.equals("PENDENTE_DE_PROCESSAMENTO")){
                pagamentoRepository.deleteById(id);
                return "OK";
            }
            else {
                return "FORBIDDEN";
            }
        }else {
            return "NOT_FOUND";
        }
    }

    public String alterarPagamento(Long id,NovoStatusPagamento statusPagamento){
        Pagamento pagamento = (pagamentoRepository.findById(id)).orElseThrow(()-> new NullPointerException("Código não existente"));
        pagamento.setStatus(statusPagamento.getStatus());
        pagamento = pagamentoRepository.save(pagamento);
        return "OK";
    }

    public List<PagamentoResponse> buscarPagamentoCpfCnpj(String cpfCnpj){
        return pagamentoRepository.findByCpfCnpj(cpfCnpj);
    }

    public List<PagamentoResponse> buscarPagamentoStatus(StatusPagamento status ){
        return pagamentoRepository.findByStatus(status);
    }
    public List<PagamentoResponse> buscarPagamentoCodigoDebito(String codigoDebito){
        return pagamentoRepository.findByCodigoDebito(codigoDebito);
    }

    public List<Pagamento> buscarPagamentos(){
        return pagamentoRepository.findAll();
    }

    public PagamentoResponse criarPagamento(PagamentoDTO pagamentoDTO){
        Pagamento pagamentoResponse = pagamentoRepository.save(new Pagamento(pagamentoDTO));
        return new PagamentoResponse(pagamentoResponse);
    }
}
