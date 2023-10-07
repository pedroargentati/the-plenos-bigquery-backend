package br.com.ford.theplenos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ford.theplenos.domain.entity.ClienteEntity;
import br.com.ford.theplenos.service.dao.BigQueryDao;

@RestController
@RequestMapping("/v2")
public class ClienteController {

	@Autowired
	private BigQueryDao<ClienteEntity> clienteEntityDao;
	
	@GetMapping(value = "/cliente")
	public ResponseEntity<List<ClienteEntity>> teste() {
		List<ClienteEntity> clientes = clienteEntityDao.findAll();
		
		return new ResponseEntity<List<ClienteEntity>>(clientes, HttpStatus.OK);
	}
	
}
