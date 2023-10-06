package br.com.ford.theplenos.domain.model;

public class QualidadeCombustivelModel {

	private Long idQualidade;
	private String nomeQualidade;

	public QualidadeCombustivelModel() {}

	public QualidadeCombustivelModel(Long idQualidade, String nomeQualidade) {
		super();
		this.idQualidade = idQualidade;
		this.nomeQualidade = nomeQualidade;
	}

	public Long getIdQualidade() {
		return idQualidade;
	}

	public void setIdQualidade(Long idQualidade) {
		this.idQualidade = idQualidade;
	}

	public String getNomeQualidade() {
		return nomeQualidade;
	}

	public void setNomeQualidade(String nomeQualidade) {
		this.nomeQualidade = nomeQualidade;
	}
	
}
