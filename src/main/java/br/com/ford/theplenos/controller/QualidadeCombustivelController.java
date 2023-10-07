package br.com.ford.theplenos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ford.theplenos.controller.exception.RecordNotFoundException;
import br.com.ford.theplenos.domain.entity.QualidadeCombustivelEntity;
import br.com.ford.theplenos.service.dao.BigQueryDao;

@RestController
@RequestMapping("/v2/fordfuel/")
public class QualidadeCombustivelController {
	
	@Autowired
	private BigQueryDao<QualidadeCombustivelEntity> qualidadeCombustivelEntityDao;

	@GetMapping(value = "/qualidadecombustivel")
	public ResponseEntity<List<QualidadeCombustivelEntity>> findAllCustomer() {
		List<QualidadeCombustivelEntity> qualidedeCombustivel = qualidadeCombustivelEntityDao.findAll();

		if (qualidedeCombustivel.isEmpty()) {
			throw new RecordNotFoundException("Nenhum registro foi encontrado.");
		}

		return new ResponseEntity<List<QualidadeCombustivelEntity>>(qualidedeCombustivel, HttpStatus.OK);
	}
}
