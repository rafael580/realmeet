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
    //    victim = new RoomService(roomRepository,roomMapper());
    }

    @Test
   public void testGetRoomSuccess() {
        var room = newRoomBuilder().id(DEFAULT_ROOM_ID).build();
        Mockito.when(roomRepository.findByIdAndActive(DEFAULT_ROOM_ID, true)).thenReturn(Optional.of(room));

        var dto = victim.getRoom(DEFAULT_ROOM_ID);
        Assertions.assertEquals(room.getId(), dto.getId());
        Assertions.assertEquals(room.getName(), dto.getName());
        Assertions.assertEquals(room.getSeats(), dto.getSeats());
    }

    @Test
   public void testGetRoomNotFound() {
        Mockito.when(roomRepository.findByIdAndActive(DEFAULT_ROOM_ID, true)).thenReturn(Optional.empty());
        assertThrows(RoomNotFoundException.class, () -> victim.getRoom(DEFAULT_ROOM_ID));
    }

}
