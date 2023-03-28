package br.com.sw2you.realmeet.validator;

import br.com.sw2you.realmeet.api.model.CreateRoomDTO;
import org.springframework.stereotype.Component;

import static br.com.sw2you.realmeet.validator.ValidatorConstants.*;

@Component
public class RoomValidator {

    public void validate(CreateRoomDTO createRoomDTO){
        var validatorErros = new ValidatiorErros();
        // Room name
        ValidatorUtils.validateRequired(createRoomDTO.getName(),ROOM_NAME,validatorErros);
        ValidatorUtils.validateMaxLength(createRoomDTO.getName(),ROOM_NAME,ROOM_NAME_MAX_LENGTH,validatorErros);

        // Room seats
        ValidatorUtils.validateRequired(createRoomDTO.getSeats(),ROOM_SEATS,validatorErros);
        ValidatorUtils.validateMinValuw(createRoomDTO.getSeats(),ROOM_NAME,ROOM_SEATS_MIN_VALUE,validatorErros);
        ValidatorUtils.validateMaxValuw(createRoomDTO.getSeats(),ROOM_NAME,ROOM_SEATS_MIN_VALUE,validatorErros);
        ValidatorUtils.thorwOnErros(validatorErros);

    }
}
