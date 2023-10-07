package br.com.ford.theplenos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.ford.theplenos.domain.entity.AbastecimentoEntity;
import br.com.ford.theplenos.domain.entity.ClienteEntity;
import br.com.ford.theplenos.domain.entity.TipoCombustivelEntity;
import br.com.ford.theplenos.domain.entity.VeiculoEntity;
import br.com.ford.theplenos.service.dao.BigQueryDao;
import br.com.ford.theplenos.service.dao.BigQueryDaoImpl;

@Configuration
public class BigQueryConfig {

	@Autowired
	private BigQueryAppProperties properties;

	@Bean
	public BigQueryDao<VeiculoEntity> veiculoEntityDao() {
		return new BigQueryDaoImpl<>(properties, VeiculoEntity.class);
	}
	
	@Bean
	public BigQueryDao<ClienteEntity> clienteEntityDao() {
		return new BigQueryDaoImpl<>(properties, ClienteEntity.class);
	}
	
	@Bean
	public BigQueryDao<TipoCombustivelEntity> tipoCombustivelEntityDao() {
		return new BigQueryDaoImpl<>(properties, TipoCombustivelEntity.class);
	}
	
	@Bean
	public BigQueryDao<AbastecimentoEntity> abastecimentoEntityDao() {
		return new BigQueryDaoImpl<>(properties, AbastecimentoEntity.class);
	}
}
