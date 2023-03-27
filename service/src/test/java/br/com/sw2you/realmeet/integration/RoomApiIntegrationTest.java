package br.com.sw2you.realmeet.integration;

import br.com.sw2you.realmeet.api.facade.RoomsApi;
import br.com.sw2you.realmeet.core.BaseIntegrationTest;
import br.com.sw2you.realmeet.domain.repository.RoomRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpClientErrorException;

import static br.com.sw2you.realmeet.utils.TestConstants.DEFAULT_ROOM_ID;
import static br.com.sw2you.realmeet.utils.TestDataCreator.newRoomBuilder;

public class RoomApiIntegrationTest extends BaseIntegrationTest {


    //cliente , porta de entrada para a api é o roomApi
    @Autowired
    private RoomsApi api;
    @Autowired
    private RoomRepository roomRepository;


    @Override
    protected void setupEach()  throws Exception {
     //   setLocalHostBasePath(api.getApiClient(),"/v1");
    }

    @Test
   public void testGetRoomSuccess(){
        var room = newRoomBuilder().build();
        roomRepository.saveAndFlush(room);

        Assertions.   assertNotNull(room.getId());
        Assertions.      assertTrue(room.getActive());

        var dto = api.getRoom(room.getId());

    //    Assertions.assertEquals(room.getId(), dto.getId());
    //    Assertions.assertEquals(room.getName(), dto.getName());
    //    Assertions.assertEquals(room.getSeats(), dto.getSeats());
    }

    @Test
    public void testGetRoomInactive(){
        var room = newRoomBuilder().active(false).build();
        roomRepository.saveAndFlush(room);

        Assertions.assertFalse(room.getActive());
        Assertions.assertThrows(HttpClientErrorException.NotFound.class,()-> api.getRoom(room.getId()));
    }

    @Test
    public void testGetRoomDoesNotExist() {
        Assertions.assertThrows(HttpClientErrorException.NotFound.class,()-> api.getRoom(DEFAULT_ROOM_ID));
    }
}
