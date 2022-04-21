package SoulCode.Servicos.Repositories;

import SoulCode.Servicos.Models.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento,Integer>{
	
	

}
