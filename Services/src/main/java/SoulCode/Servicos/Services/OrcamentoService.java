package SoulCode.Servicos.Services;

import SoulCode.Servicos.Models.Orcamento;
import SoulCode.Servicos.Repositories.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrcamentoService {

    @Autowired
    OrcamentoRepository orcamentoRepository;

    public Orcamento inserirOrcamento(Orcamento orcamento) {
        orcamento.setIdOrcamento(null);
        return orcamentoRepository.save(orcamento);
    }

    public Orcamento mostrarUmOrcamento(Integer idOrcamento) {
        Optional<Orcamento> orcamento = orcamentoRepository.findById(idOrcamento);
        return orcamento.orElseThrow();
    }

    public Orcamento editarOrcamento (Orcamento orcamento) {
        mostrarUmOrcamento(orcamento.getIdOrcamento());
        return orcamentoRepository.save(orcamento);
    }

    public void deletarOrcamento (Integer idOrcamento) {
        mostrarUmOrcamento(idOrcamento);
        orcamentoRepository.deleteById(idOrcamento);
    }
}