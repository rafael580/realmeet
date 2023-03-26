package br.com.sw2you.realmeet.unit;


import br.com.sw2you.realmeet.mapper.RoomMapper;
import org.junit.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.sw2you.realmeet.utils.TestConstants.DEFAULT_ROOM_ID;

import static br.com.sw2you.realmeet.utils.TestDataCreator.newRoomBuilder;
import static br.com.sw2you.realmeet.utils.TestMapperUtils.roomMapper;


@ExtendWith(MockitoExtension.class)
public class RoomMapperUnitTest {


    private RoomMapper victin;

    // antes de cada teste esta funcao vai ser executada
    @BeforeEach
    void setupEach(){
        victin = roomMapper();
    }

    @Test
   public void testFromEntityDTO(){
        var room = newRoomBuilder().Id(DEFAULT_ROOM_ID).build();
        var dto = victin.fromEntityToDTO(room);

        Assertions.assertEquals(room.getId(), dto.getId());
        Assertions.assertEquals(room.getName(), dto.getName());
        Assertions.assertEquals(room.getSeats(), dto.getSeats());
    }

    @Test
    public void numero(){
        Assertions.assertEquals(1,1);
    }

}
