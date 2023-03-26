package br.com.sw2you.realmeet.controller;

import static java.util.concurrent.CompletableFuture.supplyAsync;

import br.com.sw2you.realmeet.api.facade.RoomsApi;
import br.com.sw2you.realmeet.api.model.RoomDTO;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import br.com.sw2you.realmeet.service.RoomService;
import br.com.sw2you.realmeet.util.ResponseEntityUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController implements RoomsApi {

    private final Executor controllerExecutor;
    private final RoomService roomService;

    private RoomController(RoomService service, Executor controllerExecutor){
        this.roomService = service;
        this.controllerExecutor = controllerExecutor;
    }

    @Override
    public CompletableFuture<ResponseEntity<RoomDTO>> getRoom(Long id) {
        // reference method tem o mesmo parametro da entrada da expressao lambda r -> ResponseEntityUtils.ok(r)
        return supplyAsync(()-> roomService.getRoom(id),controllerExecutor).thenApply(ResponseEntityUtils::ok);
    }
}
