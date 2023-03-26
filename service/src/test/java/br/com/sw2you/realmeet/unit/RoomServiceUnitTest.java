package br.com.sw2you.realmeet.unit;

import br.com.sw2you.realmeet.domain.repository.RoomRepository;
import br.com.sw2you.realmeet.mapper.RoomMapper;
import br.com.sw2you.realmeet.service.RoomService;
import br.com.sw2you.realmeet.utils.TestMapperUtils;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static br.com.sw2you.realmeet.utils.TestConstants.DEFAULT_ROOM_ID;
import static br.com.sw2you.realmeet.utils.TestDataCreator.newRoomBuilder;
import static br.com.sw2you.realmeet.utils.TestMapperUtils.roomMapper;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RoomServiceUnitTest {

    private RoomMapper victim;

    //cria um objeto ficticio que nao ta ligado ao banco de dados que nos controlamos o que ele retorna
    @Mock
    private RoomService roomRepository;

    // antes de cada teste esta funcao vai ser executada
    @BeforeEach
    void setupEach(){
        victim = new RoomService(roomRepository, TestMapperUtils.roomMapper());
    }

    @Test
    void testGetRoomSuccess() {
        var room = newRoomBuilder().id(DEFAULT_ROOM_ID).build();
        when(roomRepository.findByIdAndActive(DEFAULT_ROOM_ID, true)).thenReturn(Optional.of(room));

        var dto = victim.getRoom(DEFAULT_ROOM_ID);
        Assertions.assertEquals(room.getId(), dto.getId());
        Assertions.assertEquals(room.getName(), dto.getName());
        Assertions.assertEquals(room.getSeats(), dto.getSeats());
    }

}
