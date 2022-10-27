package com.trepudox.kafkahexagonal.infrastructure.mapper;

import com.trepudox.kafkahexagonal.application.dto.ClienteImpactadoCardDTO;
import com.trepudox.kafkahexagonal.domain.ClienteImpactado;
import com.trepudox.kafkahexagonal.infrastructure.persistence.model.ClienteImpactadoModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteImpactadoMapper {

    ClienteImpactadoMapper INSTANCE = Mappers.getMapper(ClienteImpactadoMapper.class);

    @Mapping(target = "app", expression = "java(model.getApp())")
    @Mapping(target = "data", expression = "java(model.getData())")
    ClienteImpactado modelToDomain(ClienteImpactadoModel model);

    @Mapping(target = "id", expression = "java(new ClienteImpactadoModelId(domain.getApp(), domain.getData()))")
    ClienteImpactadoModel domainToModel(ClienteImpactado domain);

    @Mapping(target = "porcentagemImpactados", expression = "java(domain.calcularPorcentagemDeImpactados().longValue())")
    @Mapping(target = "porcentagemAltaPrioridade", expression = "java(domain.calcularPorcentagemDeAltaPrioridade().longValue())")
    @Mapping(target = "porcentagemBaixaPrioridade", expression = "java(domain.calcularPorcentagemDeBaixaPrioridade().longValue())")
    ClienteImpactadoCardDTO domainToCardDTO(ClienteImpactado domain);

}
