package br.com.ford.theplenos.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.ford.theplenos.domain.model.VeiculoModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "Veiculo")
@Table(name = "veiculo")
public class VeiculoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("IdVeiculo")
	private Long idVeiculo;
	
	@Column(name = "placaVeiculo")
	@JsonProperty("PlacaVeiculo")
	private String placaVeiculo;

	@Column(name = "idCliente")
	@JsonProperty("IdCliente")
	private Long idCliente;
	
	public VeiculoEntity() {}
	
	public VeiculoEntity(VeiculoModel model) {
		this(model.getIdVeiculo(), model.getPlacaVeiculo(), model.getIdCliente());
	}
	
	public VeiculoEntity(Long idVeiculo, String placaVeiculo, Long idCliente) {
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
