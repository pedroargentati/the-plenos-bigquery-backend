package br.com.ford.theplenos.domain.projection;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AbastecimentoProjection {
	@JsonProperty("IdAbastecimento")
	private Long idAbastecimento;

	@JsonProperty("IdPosto")
	private Long idPosto;

	@JsonProperty("NomePosto")
	private String nomePosto;

	@JsonProperty("Rua")
	private String rua;

	@JsonProperty("Bairro")
	private String bairro;

	@JsonProperty("Cidade")
	private String cidade;

	@JsonProperty("Estado")
	private String estado;

	@JsonProperty("CEP")
	private String cep;

	@JsonProperty("IdVeiculo")
	private Long idVeiculo;

	@JsonProperty("IdCombustivel")
	private Long idCombustivel;

	@JsonProperty("IdQualidade")
	private Long idQualidade;

	@JsonProperty("DataHora")
	private Date dataHora;

	@JsonProperty("IdCliente")
	private Long idCliente;

	@JsonProperty("NomeCliente")
	private String nomeCliente;
	
	@JsonProperty("NomeCombustivel")
	private String nomeCombustivel;
}
