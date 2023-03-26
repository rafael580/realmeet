package br.com.sw2you.realmeet.service;

import br.com.sw2you.realmeet.api.model.RoomDTO;
import br.com.sw2you.realmeet.domain.entity.Room;
import br.com.sw2you.realmeet.domain.repository.RoomRepository;
import br.com.sw2you.realmeet.exception.RoomNotFoundException;
import br.com.sw2you.realmeet.mapper.RoomMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class RoomService {


    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomService(RoomRepository roomRepository,RoomMapper roomMapper){
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    public RoomDTO getRoom(Long id){
        Objects.requireNonNull(id);
        Room room =  roomRepository.findById(id).orElseThrow(()-> new RoomNotFoundException("Room not found"));
        System.out.println("");
        RoomDTO roomDTO =  roomMapper.fromEntityToDTO(room);
        return roomDTO;
    }

    private void clonarDtop(Room room, RoomDTO roomDTO){
        roomDTO.name(room.getName()).seats(room.getSeats()).id(room.getId());
    }

}
