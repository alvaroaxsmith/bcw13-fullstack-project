package SoulCode.Servicos.Models.Enuns;

public enum FormaPagamento {

	CARTAO_DEBITO("Cartão de credito"),
	CARTAO_CREDITO("Cartão de credito"),
	BOLETO("Boleto");

	private String descricao;

	FormaPagamento(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
