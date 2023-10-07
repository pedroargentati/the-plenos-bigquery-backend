package br.com.ford.theplenos.service.integration;

import java.util.Date;
import java.util.List;

import com.byteowls.jopencage.JOpenCageGeocoder;
import com.byteowls.jopencage.model.JOpenCageResponse;
import com.byteowls.jopencage.model.JOpenCageResult;
import com.byteowls.jopencage.model.JOpenCageReverseRequest;

import br.com.ford.theplenos.domain.model.OpencageIntegrationModel;
import br.com.ford.theplenos.exception.IntegrationException;

public class OpencageIntegration {
	
    // Chave da API do OpenCage
	public static final String API_KEY = "91c4f0a5aafc407bb4576f286d507dc7";

    /**
     * Realiza a integração com o serviço OpenCage para obter informações com base nas coordenadas.
     *
     * @param latitude  Latitude da localização.
     * @param longitude Longitude da localização.
     * @return Objeto OpencageIntegrationModel com as informações obtidas da integração.
     * @throws IntegrationException Se ocorrer um erro durante a integração.
     */
	public static OpencageIntegrationModel makeIntegration(Double latitude, Double longitude) throws IntegrationException {
		JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder(API_KEY);

		JOpenCageReverseRequest request = new JOpenCageReverseRequest(latitude, longitude);

		JOpenCageResponse response = jOpenCageGeocoder.reverse(request);

		OpencageIntegrationModel openCageResponseFormatted = prepareResponse(response);
		
		return openCageResponseFormatted;
	}
	
    /**
     * Prepara a resposta da integração do OpenCage e mapeia os dados para o modelo OpencageIntegrationModel.
     *
     * @param response Resposta da requisição ao OpenCage.
     * @return Objeto OpencageIntegrationModel com os dados formatados da resposta.
     * @throws IntegrationException Se ocorrer um erro ao preparar a resposta.
     */
	private static OpencageIntegrationModel prepareResponse(JOpenCageResponse response) throws IntegrationException {
		OpencageIntegrationModel opencageIntegrationModel = new OpencageIntegrationModel();
		
		List<JOpenCageResult> results = response.getResults();
		if (results != null && !results.isEmpty()) {
			if (results.size() == 1) {
				JOpenCageResult jOpenResult = results.get(0);
				
				opencageIntegrationModel.setLat(jOpenResult.getGeometry().getLat());
				opencageIntegrationModel.setLng(jOpenResult.getGeometry().getLng());
				opencageIntegrationModel.setType(jOpenResult.getComponents().getType());
				opencageIntegrationModel.setContinent(jOpenResult.getComponents().getContinent());
				opencageIntegrationModel.setCity(jOpenResult.getComponents().getCity());
				opencageIntegrationModel.setCounty(jOpenResult.getComponents().getCountry());
				opencageIntegrationModel.setAddress(jOpenResult.getFormatted());
				opencageIntegrationModel.setEstado(jOpenResult.getComponents().getState());
				opencageIntegrationModel.setRua(jOpenResult.getComponents().getRoad());
				opencageIntegrationModel.setBairro(jOpenResult.getComponents().getSuburb());
				opencageIntegrationModel.setCep(jOpenResult.getComponents().getPostcode());
				opencageIntegrationModel.setRegion(jOpenResult.getComponents().getRegion());

			} else {
				results.forEach((jOpenResult) -> {
					OpencageIntegrationModel openCageItem = new OpencageIntegrationModel();
					
					openCageItem.setLat(jOpenResult.getGeometry().getLat());
					openCageItem.setLng(jOpenResult.getGeometry().getLng());
					openCageItem.setType(jOpenResult.getComponents().getType());
					openCageItem.setContinent(jOpenResult.getComponents().getContinent());
					openCageItem.setCity(jOpenResult.getComponents().getCity());
					openCageItem.setCounty(jOpenResult.getComponents().getCountry());
					openCageItem.setAddress(jOpenResult.getFormatted());
					openCageItem.setEstado(jOpenResult.getComponents().getState());
					openCageItem.setRua(jOpenResult.getComponents().getRoad());
					openCageItem.setBairro(jOpenResult.getComponents().getSuburb());
					openCageItem.setCep(jOpenResult.getComponents().getPostcode());
					openCageItem.setRegion(jOpenResult.getComponents().getRegion());
					
					opencageIntegrationModel.getResponseList().add(opencageIntegrationModel);
				});
			}
		} else {
			throw new IntegrationException("[ERRO DE INTEGRAÇÃO] - Nenhum registro foi encontrado para essas coordenadas.", "(prepareResponse)", 500);
		}
		
		opencageIntegrationModel.setAbastecimentoDate(new Date());
		return opencageIntegrationModel;
		
	}

}