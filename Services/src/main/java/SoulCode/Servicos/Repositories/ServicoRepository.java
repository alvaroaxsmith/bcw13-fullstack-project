package SoulCode.Servicos.Repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import SoulCode.Servicos.Models.Funcionario;
import SoulCode.Servicos.Models.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {

	// esse método vai trazer todos os serviços de um determinado funcionario
	// como na tabela de servico, nós temos o atributo funionário, devemos fazer uso
	// do findBy
	// o nome do método será findByFuncionario e recebe como parâmetro um optional
	// de funcionario
	List<Servico> findByFuncionario(Optional<Funcionario> funcionario);

	List<Servico> findByDataEntrada(Date data);

	@Query(value = "SELECT * FROM servico WHERE data_entrada BETWEEN :data1 AND :data2", nativeQuery = true)
	List<Servico> findByIntervaloData(Date data1, Date data2);
	
	@Query(value = "SELECT * FROM servico WHERE status = :status",nativeQuery = true)
	List<Servico> findByStatus(String status);
	
	@Query(value = "SELECT * FROM servico WHERE id_funcionario is null",nativeQuery = true)
	List<Servico> findByIdFuncionarioNull();
	
	
}
