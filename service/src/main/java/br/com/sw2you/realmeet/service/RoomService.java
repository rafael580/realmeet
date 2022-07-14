package br.com.sw2you.realmeet.service;

import br.com.sw2you.realmeet.api.model.RoomDTO;
import br.com.sw2you.realmeet.domain.entity.Room;
import br.com.sw2you.realmeet.mapper.RoomMapper;
import br.com.sw2you.realmeet.domain.repository.RoomRepository;
import br.com.sw2you.realmeet.exception.RoomNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RoomService {


    private final RoomRepository repository;
    private final RoomMapper roomMapper;

    public RoomService(RoomRepository roomRepository,RoomMapper roomMapper){
        this.repository = roomRepository;
        this.roomMapper = roomMapper;
    }

    public RoomDTO findById(Long id){
        Objects.requireNonNull(id);
       Room room = repository.findById(id).orElseThrow(RoomNotFoundException::new);
       return roomMapper.fromEntityToDto(room);
    }
}
