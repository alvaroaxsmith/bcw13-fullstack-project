package SoulCode.Servicos.Repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import SoulCode.Servicos.Models.Servico;
import org.springframework.data.jpa.repository.Query;


public interface ServicoRepository extends JpaRepository<Servico,Integer>{


	List<Servico> findBy(Integer idFuncionario, Date data);


	//Para a tabela de Serviços, criar um método get pelo Id do Funcionário e a data de Entrada do serviço #77
	@Query(value = "select * from servico WHERE id_funcionario = :idFuncionario and  data_entrada = :data", nativeQuery = true)
	List<Servico> card52(Integer idFuncionario, Date data);

	//Para a tabela de Serviços, criar um método get para buscar os serviços de determinada para frente #78
	@Query(value = "select * from servico WHERE data_entrada between :dataInicio and CURRENT_DATE()", nativeQuery = true)
	List<Servico> card53(Date dataInicio);

	//Para a tabela de Serviços, criar um método get para buscar todos os serviços concluídos de um determinado funcionario #79
	@Query(value = "select * from servico WHERE id_funcionario = :idFuncionario and status = 'CONCLUIDO'", nativeQuery = true)
	List<Servico> card54(Integer idFuncionario);

	//Para a tabela de Serviços, criar um método get para buscar todos os serviços concluídos dentro de um intervalo de datas #80
	@Query(value = "select * from servico WHERE status = 'CONCLUIDO' and (data_entrada between :dataInicio and :dataFinal)", nativeQuery = true)
	List<Servico> card55(Date dataInicio, Date dataFinal);

	//Para a tabela de Serviço, criar um método get para buscar todos os serviços concluídos de um determinado funcionário em um determinado períodi #81
	@Query(value = "select * from servico WHERE id_funcionario = :idFuncionario and (data_entrada between :dataInicio and :dataFinal) and status = 'CONCLUIDO'", nativeQuery = true)
	List<Servico> card56(Integer idFuncionario, Date dataInicio, Date dataFinal);


	//Para a tabela de Serviço, criar um método get para buscar todos os métodos atribuídos a um determinado funcionário a partir de determinada data #82
	@Query(value = "select * from servico WHERE id_funcionario = :idFuncionario and (data_entrada between :dataInicio and CURRENT_DATE ()) and status = 'ATRIBUIDO'", nativeQuery = true)
	List<Servico> card57(Integer idFuncionario, Date dataInicio);
}


