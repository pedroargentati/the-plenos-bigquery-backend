package br.com.ford.theplenos.domain.model;

public class VeiculoModel {
	
	private Long idVeiculo;
	private String placaVeiculo;
	private Long idCliente;

	public VeiculoModel() {}

	public VeiculoModel(Long idVeiculo, String placaVeiculo, Long idCliente) {
		super();
		this.idVeiculo = idVeiculo;
		this.placaVeiculo = placaVeiculo;
		this.idCliente = idCliente;
	}

	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	
}
