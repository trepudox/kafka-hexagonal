package com.trepudox.kafkahexagonal.infrastructure.configuration;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeDynamoDBConverter implements DynamoDBTypeConverter<String, LocalDateTime> {

    @Override
    public String convert(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
    }

    @Override
    public LocalDateTime unconvert(String string) {
        return LocalDateTime.parse(string, DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
    }

}
