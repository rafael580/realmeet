package br.com.sw2you.realmeet.controller;

import br.com.sw2you.realmeet.api.facade.RoomsApi;
import br.com.sw2you.realmeet.api.model.RoomDTO;
import br.com.sw2you.realmeet.service.RoomService;
import br.com.sw2you.realmeet.util.ResponseEntityUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
public class RoomController implements RoomsApi {

    private final RoomService roomService;
    private final Executor controllerExecuter;

    public RoomController(RoomService roomService,Executor executor){
        this.roomService = roomService;
        this.controllerExecuter = executor;
    }

    @Override
    public CompletableFuture<ResponseEntity<RoomDTO>> getRoom(Long id) {
        return  CompletableFuture.supplyAsync(()-> roomService.findById(id), controllerExecuter).thenApply(r->ResponseEntityUtils.ok(r));
    }
}
