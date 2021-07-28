package utils;

import com.fabiano.dio.personapi.dto.request.PhoneDTO;
import com.fabiano.dio.personapi.entity.Phone;
import com.fabiano.dio.personapi.enums.PhoneType;

public class PhoneUtils {

    private static final String PHONE_NUMBER= "1199999-000";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO(){
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone creayeFakeEntity(){
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
