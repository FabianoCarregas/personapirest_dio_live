package com.fabiano.dio.personapi.service;

import com.fabiano.dio.personapi.dto.MessageResponseDTO;
import com.fabiano.dio.personapi.dto.request.PersonDTO;
import com.fabiano.dio.personapi.entity.Person;
import com.fabiano.dio.personapi.exception.PersonNotFoundException;
import com.fabiano.dio.personapi.mapper.PersonMapper;
import com.fabiano.dio.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper;

    public MessageResponseDTO createPerson( PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return createMethodResponse(savedPerson.getId(), "Created person with ID");
    }
    public List<PersonDTO> listAll(){
        List<Person> allPeople =personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);

        return personMapper.toDTO(person);
        }


    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);

        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);

        Person personToUpdate = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToUpdate);
        return createMethodResponse(updatedPerson.getId(), "Updated person with ID");

    }
    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(()-> new PersonNotFoundException(id));
    }
    private MessageResponseDTO createMethodResponse(Long id, String s) {
        return MessageResponseDTO
                .builder()
                .message(s + id)
                .build();
    }
}

