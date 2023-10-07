package br.com.ford.theplenos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ford.theplenos.controller.exception.RecordNotFoundException;
import br.com.ford.theplenos.domain.entity.AbastecimentoEntity;
import br.com.ford.theplenos.domain.projection.AbastecimentoProjection;
import br.com.ford.theplenos.service.dao.BigQueryDao;

@RestController
@RequestMapping("/v2/fordfuel/")
public class AbastecimentoController {

	@Autowired
	private BigQueryDao<AbastecimentoEntity> abastecimentoEntityDao;
	
	@Autowired
	private BigQueryDao<AbastecimentoProjection> abastecimentoProjectionDao;
	
	@GetMapping(value = "/abastecimento")
	public ResponseEntity<List<AbastecimentoEntity>> findAllCustomer() {
	    List<AbastecimentoEntity> abastecimentos = abastecimentoEntityDao.findAll();
	    
	    if (abastecimentos.isEmpty()) {
	        throw new RecordNotFoundException("Nenhum abastecimento foi encontrado.");
	    }
	    
	    return new ResponseEntity<List<AbastecimentoEntity>>(abastecimentos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/abastecimentos-detalhados")
	public ResponseEntity<List<AbastecimentoProjection>> findAllAbastecimentosWithDetails() {
	    List<AbastecimentoProjection> result = abastecimentoProjectionDao.findAllAbastecimentosWithDetails();
	    
	    if (result.isEmpty()) {
	        throw new RecordNotFoundException("Nenhum abastecimento encontrado.");
	    }
	    
	    return new ResponseEntity<>(result, HttpStatus.OK);
	}

	
}
