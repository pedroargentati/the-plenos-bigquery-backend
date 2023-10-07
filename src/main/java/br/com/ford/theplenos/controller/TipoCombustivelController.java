package br.com.ford.theplenos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ford.theplenos.domain.entity.TipoCombustivelEntity;
import br.com.ford.theplenos.service.dao.BigQueryDao;

@RestController
@RequestMapping("/v2/fordfuel/")
public class TipoCombustivelController {

	@Autowired
	private BigQueryDao<TipoCombustivelEntity> tipoCombustivelEntityDao;
	
	@GetMapping(value = "/tipocombustivel")
	public ResponseEntity<List<TipoCombustivelEntity>> findAllCustomer() {
		List<TipoCombustivelEntity> tiposCombustivel = tipoCombustivelEntityDao.findAll();
		
		return new ResponseEntity<List<TipoCombustivelEntity>>(tiposCombustivel, HttpStatus.OK);
	}
	
}
