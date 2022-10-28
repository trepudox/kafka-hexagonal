package com.trepudox.kafkahexagonal.infrastructure.persistence.repository;

import com.trepudox.kafkahexagonal.infrastructure.persistence.id.ClienteImpactadoModelId;
import com.trepudox.kafkahexagonal.infrastructure.persistence.model.ClienteImpactadoModel;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableScan
public interface ClienteImpactadoRepository extends DynamoDBCrudRepository<ClienteImpactadoModel, ClienteImpactadoModelId> {

    List<ClienteImpactadoModel> findAllByData(String data);

}
