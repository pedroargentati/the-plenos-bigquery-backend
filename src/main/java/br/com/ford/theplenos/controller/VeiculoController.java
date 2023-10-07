package br.com.ford.theplenos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ford.theplenos.controller.exception.RecordNotFoundException;
import br.com.ford.theplenos.domain.entity.VeiculoEntity;
import br.com.ford.theplenos.service.dao.BigQueryDao;

@RestController
@RequestMapping("/v2/fordfuel/")
public class VeiculoController {

	@Autowired
	private BigQueryDao<VeiculoEntity> veiculoEntityDao;
	
	@GetMapping(value = "/veiculo")
	public ResponseEntity<List<VeiculoEntity>> findAllCustomer() {
	    List<VeiculoEntity> tiposCombustivel = veiculoEntityDao.findAll();
	    
	    if (tiposCombustivel.isEmpty()) {
	        throw new RecordNotFoundException("Nenhum veículo encontrado.");
	    }
	    
	    return new ResponseEntity<List<VeiculoEntity>>(tiposCombustivel, HttpStatus.OK);
	}

	
}
