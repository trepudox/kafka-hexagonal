package com.trepudox.kafkahexagonal.infrastructure.mapper;

import com.trepudox.kafkahexagonal.domain.ClienteImpactado;
import com.trepudox.kafkahexagonal.infrastructure.persistence.model.ClienteImpactadoModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(imports = {LocalDateTime.class, DateTimeFormatter.class})
public interface ClienteImpactadoInfraMapper {

    ClienteImpactadoInfraMapper INSTANCE = Mappers.getMapper(ClienteImpactadoInfraMapper.class);

    @Mapping(target = "data", source = "date")
    ClienteImpactado modelToDomain(ClienteImpactadoModel model);

    @Mapping(target = "date", source = "data")
    ClienteImpactadoModel domainToModel(ClienteImpactado domain);

}
