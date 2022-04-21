package SoulCode.Servicos.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import SoulCode.Servicos.Models.Enuns.StatusServico;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Servico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idServico;
		
	@Column(nullable = false, length = 100)
	private String titulo;
		
	@Column(nullable = false)
	private String descricao;
	
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Column(columnDefinition = "date", nullable = false)
	//@Temporal(TemporalType.DATE) //sem salvar a hora, só o dia
	private Date dataEntrada;
		
	@Enumerated(EnumType.STRING)
	private StatusServico status;
	
	
	
	@ManyToOne
	@JoinColumn(name = "idFuncionario")
	private Funcionario funcionario;

	public Integer getIdServico() {
		return idServico;
	}


	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Date getDataEntrada() {
		return dataEntrada;
	}


	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}


	public StatusServico getStatus() {
		return status;
	}


	public void setStatus(StatusServico status) {
		this.status = status;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	

	
	

	
}
