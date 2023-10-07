package br.com.ford.theplenos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ford.theplenos.domain.model.OpencageIntegrationModel;
import br.com.ford.theplenos.exception.IntegrationException;
import br.com.ford.theplenos.service.integration.OpencageIntegration;

@RestController
@RequestMapping("/v2/fordfuel/")
public class OpenCageIntegrationController {
	
	/**
	 * Endpoint para integrar com o serviço OpenCage a partir das coordenadas fornecidas.
	 *
	 * @param coordinates Coordenadas no formato "latitude,longitude" (por exemplo, "12.34,56.78").
	 * @return Detalhes da integração OpenCage.
	 * @throws IntegrationException Se ocorrer um erro durante a integração.
	 */
	@GetMapping("/integracao")
	public ResponseEntity<OpencageIntegrationModel> makeIntegration(@RequestParam String coordinates)
			throws IntegrationException {
		String[] coords = coordinates.split(",");

		if (coords.length != 2) {
			return ResponseEntity.badRequest().build();
		}

		try {
			Double latitude = Double.parseDouble(coords[0]);
			Double longitude = Double.parseDouble(coords[1]);

			OpencageIntegrationModel response = OpencageIntegration.makeIntegration(latitude, longitude);
			return ResponseEntity.ok(response);
		} catch (NumberFormatException e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
