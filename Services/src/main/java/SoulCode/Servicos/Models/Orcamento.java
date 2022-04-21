package SoulCode.Servicos.Models;

import SoulCode.Servicos.Models.Enuns.FormaPagamento;
import SoulCode.Servicos.Models.Enuns.StatusPagamento;
import SoulCode.Servicos.Models.Enuns.StatusServico;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Orcamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idOrcamento;
		
	@Column(nullable = false)
	private double valor;
		
	@Column(nullable = false)
	private String descricao;
		
	@Enumerated(EnumType.STRING)
	private FormaPagamento formaPagamento;

	@Enumerated(EnumType.STRING)
	private StatusPagamento statusPagamento;

	@OneToOne
	@JoinColumn(name = "id_servico")
	private Servico servico;
	


	
}
