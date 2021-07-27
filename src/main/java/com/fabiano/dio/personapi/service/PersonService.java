package com.fabiano.dio.personapi.service;

import com.fabiano.dio.personapi.dto.MessageResponseDTO;
import com.fabiano.dio.personapi.dto.request.PersonDTO;
import com.fabiano.dio.personapi.entity.Person;
import com.fabiano.dio.personapi.mapper.PersonMapper;
import com.fabiano.dio.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper= PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson( PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID" + savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll(){
        List<Person> allPeople =personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::tpDTO)
                .collect(Collectors.toList());
    }

}
