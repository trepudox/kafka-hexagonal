package com.trepudox.kafkahexagonal.infrastructure.persistence.id;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteImpactadoModelId {

    @DynamoDBHashKey
    private String app;

    @DynamoDBRangeKey
    private LocalDateTime data;

}
