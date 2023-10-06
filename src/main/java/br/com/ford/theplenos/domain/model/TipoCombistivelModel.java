package br.com.ford.theplenos.domain.model;

public class TipoCombistivelModel {

	private Long idCombustivel;
	private String nomeCombustivel;

	public TipoCombistivelModel( ) {}

	public TipoCombistivelModel(Long idCombustivel, String nomeCombustivel) {
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
