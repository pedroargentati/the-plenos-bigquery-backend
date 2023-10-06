package br.com.ford.theplenos.domain.model;

public class ClienteModel {

	private Long idCliente;
	private String nomeCliente;
	
	public ClienteModel() {}

	public ClienteModel(Long idCliente, String nomeCliente) {
		super();
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
}
