package br.com.sw2you.realmeet.utils;



import br.com.sw2you.realmeet.mapper.RoomMapper;
import org.mapstruct.factory.Mappers;
public final class TestMapperUtils {

    private TestMapperUtils() {}

    public static RoomMapper roomMapper() {
        return Mappers.getMapper(RoomMapper.class);
    }
}