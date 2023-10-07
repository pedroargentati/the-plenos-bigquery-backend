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
import br.com.ford.theplenos.service.dao.BigQueryDao;

@RestController
@RequestMapping("/v2/fordfuel/")
public class AbastecimentoController {

	@Autowired
	private BigQueryDao<AbastecimentoEntity> abastecimentoEntityDao;
	
	@GetMapping(value = "/abastecimento")
	public ResponseEntity<List<AbastecimentoEntity>> findAllCustomer() {
	    List<AbastecimentoEntity> tiposCombustivel = abastecimentoEntityDao.findAll();
	    
	    if (tiposCombustivel.isEmpty()) {
	        throw new RecordNotFoundException("Nenhum abastecimento foi encontrado.");
	    }
	    
	    return new ResponseEntity<List<AbastecimentoEntity>>(tiposCombustivel, HttpStatus.OK);
	}

	
}
