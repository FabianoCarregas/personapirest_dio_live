package utils;

import com.fabiano.dio.personapi.dto.request.PersonDTO;
import com.fabiano.dio.personapi.entity.Person;
import com.fabiano.dio.personapi.entity.Phone;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    private static final String FIRT_NAME = "Fabiano";
    private static final String LAST_NAME = "Peleias";
    private static final String CPF_NUMBER = "222.222.222.22";
    private static final long PERSON_ID = 1L;
    private static final LocalDate BIRTH_DATE = LocalDate.of(2000, 10,02);

    public static PersonDTO createFakeDTO(){
        return PersonDTO.builder()
                .firtName(FIRT_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("09-09-2000")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity(){
        return Person.builder()
                .id(PERSON_ID)
                .firtName(FIRT_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.creayeFakeEntity()))
                .build();
    }
}
