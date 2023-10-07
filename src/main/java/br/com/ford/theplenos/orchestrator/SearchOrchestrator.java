package br.com.ford.theplenos.orchestrator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.google.cloud.bigquery.JobId;

import br.com.ford.theplenos.domain.entity.AbastecimentoEntity;
import br.com.ford.theplenos.service.BigQueryService;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SearchOrchestrator {

//    private BigQueryService service;
//
//    public SearchOrchestrator(final BigQueryService service) {
//        this.service = service;
//    }
//
//    /**
//     * Search by year
//     *
//     * Try to use BigQuery to search by year - Throw internal exception on failure
//     * Will handle empty results by passing back null UUID
//     * Make saveall call to the repo on successful results from BigQuery
//     *
//     * @param year the year to search for
//     * @return UUID {@link UUID}
//     */
//
//    public Optional<UUID> searchByYear(final String year) {
//        final UUID reqeustId = UUID.randomUUID();
//        final JobId jobId = JobId.of(reqeustId.toString());
//        
//        final List<AbastecimentoEntity> abastecimentoEntityList = new ArrayList<>();
//        List<String> resultList = new ArrayList<>();
//
//        // call our bigquery service
//        resultList = service.filAllAbastecimento(jobId);
//
//        // if result list is empty return null else save down results and return normal requestId
//        if (resultList.isEmpty()) {
//            return Optional.empty();
//        } else {
//            resultList.forEach(result -> {
//            	
//                abastecimentoEntityList.add(dataSetEntity);
//            });
//
//            repository.saveAll(abastecimentoEntityList);
//        }
//        return Optional.of(reqeustId);
//    }
}
