package br.com.ford.theplenos.service.dao;

import java.util.List;

import br.com.ford.theplenos.domain.projection.AbastecimentoProjection;
import br.com.ford.theplenos.exception.BigQuerySearchException;

public interface BigQueryDao<T> {
	List<T> findAll() throws BigQuerySearchException;

	List<AbastecimentoProjection> findAllAbastecimentosWithDetails() throws BigQuerySearchException;

}
