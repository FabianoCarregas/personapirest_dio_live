package com.fabiano.dio.personapi.mapper;

import com.fabiano.dio.personapi.dto.request.PersonDTO;
import com.fabiano.dio.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO dto);

    PersonDTO toDTO(Person dto);



}
