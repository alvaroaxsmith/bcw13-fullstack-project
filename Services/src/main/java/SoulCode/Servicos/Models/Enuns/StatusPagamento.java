package SoulCode.Servicos.Models.Enuns;

public enum StatusPagamento {

	AGUARDANDO("Pagamento em espera"),
	QUITADO("Pago"),
	CANCELADO("Cancelado");

	private String descricao;

	StatusPagamento(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
