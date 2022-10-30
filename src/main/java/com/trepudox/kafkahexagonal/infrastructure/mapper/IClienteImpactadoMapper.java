package com.trepudox.kafkahexagonal.infrastructure.mapper;

import com.trepudox.kafkahexagonal.domain.ClienteImpactado;
import com.trepudox.kafkahexagonal.infrastructure.persistence.id.ClienteImpactadoModelId;
import com.trepudox.kafkahexagonal.infrastructure.persistence.model.ClienteImpactadoModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(imports = {ClienteImpactadoModelId.class, LocalDateTime.class, DateTimeFormatter.class})
public interface ClienteImpactadoMapper {

    ClienteImpactadoMapper INSTANCE = Mappers.getMapper(ClienteImpactadoMapper.class);

    @Mapping(target = "app", expression = "java(model.getId().getApp())")
    @Mapping(target = "data", expression = "java(LocalDateTime.parse(model.getId().getData(), DateTimeFormatter.ofPattern(\"ddMMyyyy'T'HHmmss\")))")
    ClienteImpactado modelToDomain(ClienteImpactadoModel model);

    @Mapping(target = "id", expression = "java(new ClienteImpactadoModelId(domain.getApp(), domain.getData().format(DateTimeFormatter.ofPattern(\"ddMMyyyy'T'HHmmss\"))))")
    ClienteImpactadoModel domainToModel(ClienteImpactado domain);

//    @Mapping(target = "porcentagemImpactados", expression = "java(domain.calcularPorcentagemDeImpactados().longValue())")
//    @Mapping(target = "porcentagemAltaPrioridade", expression = "java(domain.calcularPorcentagemDeAltaPrioridade().longValue())")
//    @Mapping(target = "porcentagemBaixaPrioridade", expression = "java(domain.calcularPorcentagemDeBaixaPrioridade().longValue())")
//    ClienteImpactadoCardDTO domainToCardDTO(ClienteImpactado domain); // FIXME: responsabilidade da application!!

}
