package br.com.sw2you.realmeet.unit;


import static br.com.sw2you.realmeet.utils.TestMapperUtils.roomMapper;
import static br.com.sw2you.realmeet.utils.TestConstants.DEFAULT_ROOM_ID;
import static br.com.sw2you.realmeet.utils.TestDataCreator.newRoomBuilder;



import br.com.sw2you.realmeet.core.BaseUnitTest;
import br.com.sw2you.realmeet.mapper.RoomMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class RoomMapperUnitTest extends BaseUnitTest {


    private RoomMapper victim;

    // antes de cada teste esta funcao vai ser executada
    @BeforeEach
    void setupEach(){
        // injeta a classe roomMapper no victim
        victim = roomMapper();
    }

    @Test
   public void testFromEntityDTO(){
        var room = newRoomBuilder().id(DEFAULT_ROOM_ID).build();
        var dto = victim.fromEntityToDTO(room);

        Assertions.assertEquals(room.getId(), dto.getId());
        Assertions.assertEquals(room.getName(), dto.getName());
        Assertions.assertEquals(room.getSeats(), dto.getSeats());
    }


}
