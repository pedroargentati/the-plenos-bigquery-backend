package br.com.ford.theplenos.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

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

@Entity(name = "Posto")
@Table(name = "posto")
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("IdPosto")
	private Long idPosto;
	
	@Column(name = "nomePosto")
	@JsonProperty("NomePosto")
	private String nomePosto;
	
	@Column(name = "rua")
	@JsonProperty("Rua")
	private String rua;
	
	@Column(name = "bairro")
	@JsonProperty("Bairro")
	private String bairro;
	
	@Column(name = "cidade")
	@JsonProperty("Cidade")
	private String cidade;
	
	@Column(name = "estado")
	@JsonProperty("Estado")
	private String estado;
	
	@Column(name = "cep")
	@JsonProperty("CEP")
	private String cep;
	
	@Column(name = "Latitude")
	@JsonProperty("Latitude")
	private String latitude;

	@Column(name = "Longitude")
	@JsonProperty("Longitude")
	private String longitude;
	
}
