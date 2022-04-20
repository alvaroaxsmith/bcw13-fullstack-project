package SoulCode.Servicos.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SoulCode.Servicos.Models.Funcionario;
import SoulCode.Servicos.Models.Servico;
import SoulCode.Servicos.Models.StatusServico;
import SoulCode.Servicos.Repositories.FuncionarioRepository;
import SoulCode.Servicos.Repositories.ServicoRepository;

@Service
public class ServicoService {
	
	@Autowired
	ServicoRepository servicoRepository;
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	// findAll (método da Spring Data) - busca todos os registros
	public List<Servico> mostrarTodosServicos(){
		return servicoRepository.findAll();	}
	
	// findById - busca um registro pela sua chave primária
	public Servico mostrarUmServico(Integer idServico) {
		Optional<Servico> servico = servicoRepository.findById(idServico);
		return servico.orElseThrow();
	}
	
	
	// findByFuncionario - busca todos os serviços de um determinado
	//funcionario
	public List<Servico> buscarServicosDoFuncionario(Integer idFuncionario){
	   Optional<Funcionario> funcionario = funcionarioRepository.findById(idFuncionario);
	   return servicoRepository.findByFuncionario(funcionario);
	}
	
	public List<Servico> buscarServicoPelaData(Date dataEntrada){
		return servicoRepository.findByDataEntrada(dataEntrada);
	}
	
	public List<Servico> buscarServicoPorIntervaloData(Date data1, Date data2){
		return servicoRepository.findByIntervaloData(data1, data2);
	}
	
	public List<Servico> buscarServicoPeloStatus(String status){
		return servicoRepository.findByStatus(status);
	}
	
	public List<Servico> buscarServicoSemFuncionario(){
		return servicoRepository.findByIdFuncionarioNull();
	}
	
	// método para cadastro de um serviço
	//no momento do cadastro do novo serviço o status tem que ficar como recebido
	//no momento do cadastro do novo serviço o idFuncionario tem que ficar como null
	public Servico inserirServico(Servico servico) {
		servico.setIdServico(null);
		servico.setStatus(StatusServico.RECEBIDO);
		servico.setFuncionario(null);
		return servicoRepository.save(servico);
	}

	// método para atribuir um determinado serviço para um determinado funcionario
	// o serviço precisa receber o status de atribuído
	public Servico atribuirFuncionario(Integer idServico, Integer idFuncionario) {
		// buscamos o funcionario para vai ser atribuído ao serviço através do seu id
		Optional<Funcionario> funcionario = funcionarioRepository.findById(idFuncionario);
		//buscamos o serviço para o qual esse funcionário vai ser atribuído
		Servico servico = mostrarUmServico(idServico);
		if (servico.getFuncionario() != null) {
			servico.setIdServico(idServico);
			servico.setFuncionario(funcionario.get());
			servico.setStatus(StatusServico.ATRIBUIDO);
		}
		return servicoRepository.save(servico);
		
	}
	
	// Método para mudar o status do serviço para conclúido
	public Servico concluirServico(Integer idServico) {
		Servico servico = mostrarUmServico(idServico);
		//servico.setIdServico(idServico);
		if (servico.getFuncionario() != null) {
			servico.setStatus(StatusServico.CONCLUIDO);
		}
		return servicoRepository.save(servico);
	}
	
	
}
