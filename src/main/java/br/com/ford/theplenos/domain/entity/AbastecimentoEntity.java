package br.com.ford.theplenos.domain.entity;

import java.util.Date;

import br.com.ford.theplenos.domain.model.AbastecimentoModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "Abastecimento")
@Table(name = "abastecimento")
public class AbastecimentoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAbastecimento;

    @Column(name = "idPosto")
    private Long idPosto;
    
    @Column(name = "idVeiculo")
    private Long idVeiculo;
    
    @Column(name = "idCombustivel")
    private Long idCombustivel;
    
    @Column(name = "idQualidadeCombustivel")
    private Long idQualidadeCombustivel;
    
    @Column(name = "dataHora")
    private Date dataHora;
    
    public AbastecimentoEntity() {}
    
    public AbastecimentoEntity(AbastecimentoModel model) {
    	this(model.getIdAbastecimento(), model.getIdPosto(), model.getIdVeiculo(), model.getIdCombustivel() ,model.getIdQualidadeCombustivel(), model.getDataHora());
    }
    
	public AbastecimentoEntity(Long idAbastecimento, Long idPosto, Long idVeiculo, Long idCombustivel, Long idQualidadeCombustivel, Date dataHora) {
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
