package com.trepudox.kafkahexagonal.infrastructure.persistence.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.trepudox.kafkahexagonal.infrastructure.persistence.id.ClienteImpactadoModelId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDBTable(tableName = "cliente_impactado")
public class ClienteImpactadoModel {

    private ClienteImpactadoModelId id;
    private int clientes;
    private int impactados;
    private int altaPrioridade;
    private int baixaPrioridade;

}
