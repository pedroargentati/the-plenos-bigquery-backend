package br.com.ford.theplenos.domain.entity;

import br.com.ford.theplenos.domain.model.PostoModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "Posto")
@Table(name = "posto")
public class PostoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPosto;
	
	@Column(name = "nomePosto")
	private String nomePosto;
	
	@Column(name = "rua")
	private String rua;
	
	@Column(name = "bairro")
	private String bairro;
	
	@Column(name = "cidade")
	private String cidade;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "cep")
	private String cep;
	
	public PostoEntity() {}
	
	public PostoEntity(PostoModel model) {
		this(model.getIdPosto(), model.getNomePosto(), model.getRua(), model.getBairro(), model.getCidade(), model.getEstado(), model.getCep());
	}
	
	public PostoEntity(Long idPosto, String nomePosto, String rua, String bairro, String cidade, String estado, String cep) {
		this.idPosto = idPosto;
		this.nomePosto = nomePosto;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}

	public Long getIdPosto() {
		return idPosto;
	}

	public void setIdPosto(Long idPosto) {
		this.idPosto = idPosto;
	}

	public String getNomePosto() {
		return nomePosto;
	}

	public void setNomePosto(String nomePosto) {
		this.nomePosto = nomePosto;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
}
