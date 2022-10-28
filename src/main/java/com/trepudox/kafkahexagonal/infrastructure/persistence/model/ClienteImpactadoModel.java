package com.trepudox.kafkahexagonal.infrastructure.persistence.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.trepudox.kafkahexagonal.infrastructure.persistence.id.ClienteImpactadoModelId;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDBTable(tableName = "cliente_impactado")
public class ClienteImpactadoModel {

    @Id
    private ClienteImpactadoModelId id;
    private int clientes;
    private int impactados;
    private int altaPrioridade;
    private int baixaPrioridade;

    @DynamoDBHashKey(attributeName = "app")
    public String getApp() {
        return id != null ? id.getApp() : null;
    }

    public void setApp(String app) {
        if(id == null)
            this.id = new ClienteImpactadoModelId();

        this.id.setApp(app);
    }

    @DynamoDBRangeKey(attributeName = "data")
    public String getData() {
        return id != null ? id.getData() : null;
    }

    public void setData(String data) {
        if(id == null)
            this.id = new ClienteImpactadoModelId();

        this.id.setData(data);
    }

}
