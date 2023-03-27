package br.com.sw2you.realmeet.unit;

import br.com.sw2you.realmeet.core.BaseUnitTest;
import br.com.sw2you.realmeet.domain.repository.RoomRepository;
import br.com.sw2you.realmeet.exception.RoomNotFoundException;
import br.com.sw2you.realmeet.service.RoomService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

import static br.com.sw2you.realmeet.utils.TestConstants.DEFAULT_ROOM_ID;
import static br.com.sw2you.realmeet.utils.TestDataCreator.newRoomBuilder;
import static br.com.sw2you.realmeet.utils.TestMapperUtils.roomMapper;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class RoomServiceUnitTest extends BaseUnitTest {

    @Mock
    private RoomRepository roomRepository;

    private RoomService victim;

    // antes de cada teste esta funcao vai ser executada
    @BeforeEach
    void setupEach(){
        // injeta a classe roomMapper no victim
        victim = new RoomService(roomRepository,roomMapper());
    }

    @Test
    public void testGetRoomSucess(){
        // chamando novo objeto  room
        var room = newRoomBuilder().Id(DEFAULT_ROOM_ID).build();
        // simulando quando este metodo for chama o que ele deve fazer
        Mockito.when(roomRepository.findByIdActive(DEFAULT_ROOM_ID,true)).thenReturn(Optional.of(room));
        // chamando o dto do service
        var dto =  victim.getRoom(DEFAULT_ROOM_ID);

        Assertions.assertEquals(room.getId(), dto.getId());
        Assertions.assertEquals(room.getName(), dto.getName());
        Assertions.assertEquals(room.getSeats(), dto.getSeats());
    }

    @Test
   public void testGetRoomNotFound() {
        Mockito.when(roomRepository.findByIdActive(DEFAULT_ROOM_ID, true)).thenReturn(Optional.empty());
        assertThrows(RoomNotFoundException.class, () -> victim.getRoom(DEFAULT_ROOM_ID));
    }

}
