package br.com.sw2you.realmeet.exception;

public class RoomNotFoundException extends RuntimeException {

        public RoomNotFoundException(String mensage){
            super(mensage);
        }

}
