package br.com.sw2you.realmeet.service;

import br.com.sw2you.realmeet.api.model.CreateRoomDTO;
import br.com.sw2you.realmeet.api.model.RoomDTO;
import br.com.sw2you.realmeet.domain.entity.Room;
import br.com.sw2you.realmeet.domain.repository.RoomRepository;
import br.com.sw2you.realmeet.exception.RoomNotFoundException;
import br.com.sw2you.realmeet.mapper.RoomMapper;
import br.com.sw2you.realmeet.validator.RoomValidator;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomValidator roomValidator;
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomService(RoomRepository roomRepository,RoomMapper roomMapper,RoomValidator roomValidator){
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
        this.roomValidator = roomValidator;
    }

    public RoomDTO getRoom(Long id){
        Objects.requireNonNull(id);
        Room room =  roomRepository.findByIdAndActive(id,true).orElseThrow(()-> new RoomNotFoundException("Room not found"));
        RoomDTO roomDTO =  roomMapper.fromEntityToDTO(room);
        return roomDTO;
    }

    public RoomDTO createRoom(CreateRoomDTO createRoomDTO){
        roomValidator.Validate(createRoomDTO);
        var room = roomMapper.fromCreateRoomDtoToEntity(createRoomDTO);
        roomRepository.save(room);
        return roomMapper.fromEntityToDTO(room);
    }


}
