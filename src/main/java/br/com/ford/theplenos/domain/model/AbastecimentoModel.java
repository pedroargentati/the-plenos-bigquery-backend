package br.com.ford.theplenos.domain.model;

import java.util.Date;

public class AbastecimentoModel {

	private Long idAbastecimento;
    private Long idPosto;
    private Long idVeiculo;
    private Long idCombustivel;
    private Long idQualidadeCombustivel;
    private Date dataHora;
    
    public AbastecimentoModel() {}

	public AbastecimentoModel(Long idAbastecimento, Long idPosto, Long idVeiculo, Long idCombustivel, Long idQualidadeCombustivel, Date dataHora) {
		this.idAbastecimento = idAbastecimento;
		this.idPosto = idPosto;
		this.idVeiculo = idVeiculo;
		this.idCombustivel = idCombustivel;
		this.idQualidadeCombustivel = idQualidadeCombustivel;
		this.dataHora = dataHora;
	}

	public Long getIdAbastecimento() {
		return idAbastecimento;
	}

	public void setIdAbastecimento(Long idAbastecimento) {
		this.idAbastecimento = idAbastecimento;
	}

	public Long getIdPosto() {
		return idPosto;
	}

	public void setIdPosto(Long idPosto) {
		this.idPosto = idPosto;
	}

	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public Long getIdCombustivel() {
		return idCombustivel;
	}

	public void setIdCombustivel(Long idCombustivel) {
		this.idCombustivel = idCombustivel;
	}

	public Long getIdQualidadeCombustivel() {
		return idQualidadeCombustivel;
	}

	public void setIdQualidadeCombustivel(Long idQualidadeCombustivel) {
		this.idQualidadeCombustivel = idQualidadeCombustivel;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
    
}
