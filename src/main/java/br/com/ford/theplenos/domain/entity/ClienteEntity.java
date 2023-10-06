package br.com.ford.theplenos.domain.entity;

import br.com.ford.theplenos.domain.model.ClienteModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "Cliente")
@Table(name = "cliente")
public class ClienteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCliente;
	
	@Column(name = "nomeCliente")
	private String nomeCliente;
	
	public ClienteEntity() {}
	
	public ClienteEntity(ClienteModel model) {
		this(model.getIdCliente(), model.getNomeCliente());
	}

	public ClienteEntity(Long idCliente, String nomeCliente) {
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
