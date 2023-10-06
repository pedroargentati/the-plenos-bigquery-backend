package br.com.ford.theplenos.domain.entity;

import br.com.ford.theplenos.domain.model.QualidadeCombustivelModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "QualidadeCombustivel")
@Table(name = "qalidadecombustivel")
public class QualidadeCombustivelEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idQualidade;
	
	@Column(name = "nomeQualidade")
	private String nomeQualidade;
	
	public QualidadeCombustivelEntity() {}
	
	public QualidadeCombustivelEntity(QualidadeCombustivelModel model) {
		this(model.getIdQualidade(), model.getNomeQualidade());
	}

	public QualidadeCombustivelEntity(Long idQualidade, String nomeQualidade) {
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
