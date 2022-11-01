package com.trepudox.kafkahexagonal.infrastructure.persistence.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.trepudox.kafkahexagonal.infrastructure.configuration.LocalDateTimeDynamoDBConverter;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDBTable(tableName = "cliente_impactado")
public class ClienteImpactadoModel {

    @DynamoDBHashKey(attributeName = "app")
    private String app;

    @DynamoDBRangeKey(attributeName = "dataHora")
    @DynamoDBIndexHashKey(attributeName = "dataHora", globalSecondaryIndexName = "dataHora_index")
    @DynamoDBTypeConverted(converter = LocalDateTimeDynamoDBConverter.class)
    private LocalDateTime dataHora;

    private int clientes;
    private int impactados;
    private int altaPrioridade;
    private int baixaPrioridade;

}
