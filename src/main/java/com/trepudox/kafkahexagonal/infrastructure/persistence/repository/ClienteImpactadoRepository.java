package com.trepudox.kafkahexagonal.infrastructure.persistence.repository;

import com.trepudox.kafkahexagonal.infrastructure.persistence.id.ClienteImpactadoModelId;
import com.trepudox.kafkahexagonal.infrastructure.persistence.model.ClienteImpactadoModel;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteImpactadoRepository extends DynamoDBCrudRepository<ClienteImpactadoModel, ClienteImpactadoModelId> {
}
