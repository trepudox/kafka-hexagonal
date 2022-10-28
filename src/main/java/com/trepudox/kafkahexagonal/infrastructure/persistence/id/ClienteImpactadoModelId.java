package com.trepudox.kafkahexagonal.infrastructure.persistence.id;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteImpactadoModelId {

    @DynamoDBHashKey(attributeName = "app")
    private String app;

    @DynamoDBRangeKey(attributeName = "data")
    @DynamoDBIndexHashKey(globalSecondaryIndexName = "data_index")
    private String data;

}
