package SoulCode.Servicos.Models.Enuns;

public enum StatusServico {
	
	RECEBIDO("Recebido"),
	ATRIBUIDO("Atribuido"),
	CONCLUIDO("Concluido");
	
	private String descricao;
	
	StatusServico(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
