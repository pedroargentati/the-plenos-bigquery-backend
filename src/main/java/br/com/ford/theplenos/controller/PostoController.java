package br.com.ford.theplenos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ford.theplenos.controller.exception.RecordNotFoundException;
import br.com.ford.theplenos.domain.entity.PostoEntity;
import br.com.ford.theplenos.service.dao.BigQueryDao;

@RestController
@RequestMapping("/v2/fordfuel/")
public class PostoController {

	@Autowired
	private BigQueryDao<PostoEntity> postoEntityDao;
	
	@GetMapping(value = "/posto")
	public ResponseEntity<List<PostoEntity>> findAllCustomer() {
	    List<PostoEntity> tiposCombustivel = postoEntityDao.findAll();
	    
	    if (tiposCombustivel.isEmpty()) {
	        throw new RecordNotFoundException("Nenhum posto foi encontrado.");
	    }
	    
	    return new ResponseEntity<List<PostoEntity>>(tiposCombustivel, HttpStatus.OK);
	}
	
}
