package com.trepudox.kafkahexagonal.infrastructure.persistence.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.trepudox.kafkahexagonal.infrastructure.persistence.model.ClienteImpactadoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ClienteImpactadoRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public void save(ClienteImpactadoModel model) {
        dynamoDBMapper.save(model);
    }

    public Optional<ClienteImpactadoModel> buscarPorAppEData(String app, String dataHora) {
        DynamoDBQueryExpression<ClienteImpactadoModel> queryExpression = new DynamoDBQueryExpression<>();

        queryExpression.setKeyConditionExpression("app = :app and #dataHora = :dataHora");
        queryExpression.setExpressionAttributeNames(Map.of("#dataHora", "date"));
        queryExpression.setExpressionAttributeValues(Map.of(":app", new AttributeValue(app),
                ":dataHora", new AttributeValue(dataHora)));

        PaginatedQueryList<ClienteImpactadoModel> result = dynamoDBMapper.query(ClienteImpactadoModel.class, queryExpression);

        return result.stream().findFirst();
    }

    public List<ClienteImpactadoModel> buscarPorAppEDataHoraMaiorQue(String app, String dataHora) {
        DynamoDBQueryExpression<ClienteImpactadoModel> queryExpression = new DynamoDBQueryExpression<>();

        queryExpression.setKeyConditionExpression("app = :app and #dataHora > :dataHora");
        queryExpression.setExpressionAttributeNames(Map.of("#dataHora", "date"));
        queryExpression.setExpressionAttributeValues(Map.of(":app", new AttributeValue(app),
                ":dataHora", new AttributeValue(dataHora)));

        PaginatedQueryList<ClienteImpactadoModel> result = dynamoDBMapper.query(ClienteImpactadoModel.class, queryExpression);

        return new ArrayList<>(result);
    }

    public List<ClienteImpactadoModel> buscarPorDataHora(String dataHora) {
        DynamoDBQueryExpression<ClienteImpactadoModel> queryExpression = new DynamoDBQueryExpression<>();

        queryExpression.setIndexName("date_index");
        queryExpression.setConsistentRead(false); // https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.ReadConsistency.html
        queryExpression.setKeyConditionExpression("#dataHora = :dataHora");
        queryExpression.setExpressionAttributeNames(Map.of("#dataHora", "date"));
        queryExpression.setExpressionAttributeValues(Map.of(":dataHora", new AttributeValue(dataHora)));

        PaginatedQueryList<ClienteImpactadoModel> result = dynamoDBMapper.query(ClienteImpactadoModel.class, queryExpression);

        return new ArrayList<>(result);
    }

}
