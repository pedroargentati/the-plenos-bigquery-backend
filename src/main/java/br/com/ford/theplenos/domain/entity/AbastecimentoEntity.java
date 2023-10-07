package br.com.ford.theplenos.domain.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.ford.theplenos.domain.model.AbastecimentoModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Abastecimento")
@Table(name = "abastecimento")
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AbastecimentoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAbastecimento;

	@Column(name = "idPosto")
	@JsonProperty("IdPosto")
	private Long idPosto;

	@Column(name = "idVeiculo")
	@JsonProperty("IdVeiculo")
	private Long idVeiculo;

	@Column(name = "idCombustivel")
	@JsonProperty("IdCombustivel")
	private Long idCombustivel;

	@Column(name = "idQualidadeCombustivel")
	@JsonProperty("IdQualidadeCombustivel")
	private Long idQualidadeCombustivel;

	@Column(name = "dataHora")
	@JsonProperty("DataHora")
	private Date dataHora;


	public AbastecimentoEntity(AbastecimentoModel model) {
		this(model.getIdAbastecimento(), model.getIdPosto(), model.getIdVeiculo(), model.getIdCombustivel(), model.getIdQualidadeCombustivel(), model.getDataHora());
	}

}
