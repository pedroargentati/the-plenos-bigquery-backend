package br.com.ford.theplenos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import br.com.ford.theplenos.domain.entity.AbastecimentoEntity;
import br.com.ford.theplenos.domain.entity.ClienteEntity;
import br.com.ford.theplenos.domain.entity.PostoEntity;
import br.com.ford.theplenos.domain.entity.QualidadeCombustivelEntity;
import br.com.ford.theplenos.domain.entity.TipoCombustivelEntity;
import br.com.ford.theplenos.domain.entity.VeiculoEntity;
import br.com.ford.theplenos.domain.projection.AbastecimentoProjection;
import br.com.ford.theplenos.service.dao.BigQueryDao;
import br.com.ford.theplenos.service.dao.BigQueryDaoImpl;

@Configuration
public class BigQueryConfig {

	@Autowired
	private BigQueryAppProperties properties;
	
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

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
	
	@Bean
	public BigQueryDao<PostoEntity> postoEntityDao() {
		return new BigQueryDaoImpl<>(properties, PostoEntity.class);
	}
	
	@Bean
	public BigQueryDao<QualidadeCombustivelEntity> qualidadeCombustivelEntityDao() {
		return new BigQueryDaoImpl<>(properties, QualidadeCombustivelEntity.class);
	}
	
	@Bean
	public BigQueryDao<AbastecimentoProjection> abastecimentoProjectionEntityDao() {
		return new BigQueryDaoImpl<>(properties, AbastecimentoProjection.class);
	}
}
