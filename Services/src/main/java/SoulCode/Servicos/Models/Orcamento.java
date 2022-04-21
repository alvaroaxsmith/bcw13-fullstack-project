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


	public Integer getIdOrcamento() {
		return idOrcamento;
	}

	public void setIdOrcamento(Integer idOrcamento) {
		this.idOrcamento = idOrcamento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public StatusPagamento getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
}
