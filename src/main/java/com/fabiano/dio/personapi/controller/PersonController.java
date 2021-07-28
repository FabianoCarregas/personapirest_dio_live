package com.fabiano.dio.personapi.controller;

import com.fabiano.dio.personapi.dto.MessageResponseDTO;
import com.fabiano.dio.personapi.dto.request.PersonDTO;
import com.fabiano.dio.personapi.exception.PersonNotFoundException;
import com.fabiano.dio.personapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

   private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Validated PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
       return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
       return personService.findById(id);
    }
    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id,@RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        return personService.updateById(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFileId(@PathVariable Long id) throws PersonNotFoundException {
       personService.delete(id);

    }



}
