package br.com.ford.theplenos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import br.com.ford.theplenos.service.BigQueryService;

@RestController
public class BigQueryController {
	
	@Autowired
	private BigQueryService service;

	@GetMapping(value = "/v1/abastecimento")
	public ResponseEntity<List<ObjectNode>> obterListaAbastecimentos() {
	    List<ObjectNode> resultList;
	    resultList = service.filAllAbastecimento();
	    System.out.println(resultList);
	    return new ResponseEntity<>(resultList, HttpStatus.OK);
	}

}
