package SoulCode.Servicos.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SoulCode.Servicos.Models.Servico;
import SoulCode.Servicos.Repositories.ServicoRepository;

@Service
public class ServicoService {
	
	@Autowired
	ServicoRepository servicoRepository;
	
	// findAll (método da Spring Data) - busca todos os registros
	public List<Servico> mostrarTodosServicos(){
		return servicoRepository.findAll();	}
	
	// findById - busca um registro pela sua chave primária
	public Servico buscarUmServico(Integer idServico) {
		Optional<Servico> servico = servicoRepository.findById(idServico);
		return servico.orElseThrow();
	}
	
	

	
}
