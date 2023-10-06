package br.com.ford.theplenos.domain.entity;

import br.com.ford.theplenos.domain.model.TipoCombistivelModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "TipoCombistivel")
@Table(name = "tipocombistivel")
public class TipoCombistivelEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCombustivel;
	
	@Column(name = "nomeCombustivel")
	private String nomeCombustivel;

	public TipoCombistivelEntity() {}
	
	public TipoCombistivelEntity(TipoCombistivelModel model) {
		this(model.getIdCombustivel(), model.getNomeCombustivel());
	}

	public TipoCombistivelEntity(Long idCombustivel, String nomeCombustivel) {
		super();
		this.idCombustivel = idCombustivel;
		this.nomeCombustivel = nomeCombustivel;
	}

	public Long getIdCombustivel() {
		return idCombustivel;
	}

	public void setIdCombustivel(Long idCombustivel) {
		this.idCombustivel = idCombustivel;
	}

	public String getNomeCombustivel() {
		return nomeCombustivel;
	}

	public void setNomeCombustivel(String nomeCombustivel) {
		this.nomeCombustivel = nomeCombustivel;
	}
}
