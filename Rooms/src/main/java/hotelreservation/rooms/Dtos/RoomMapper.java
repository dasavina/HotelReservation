package hotelreservation.rooms.Dtos;


import hotelreservation.rooms.Entities.Room;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    RoomDTO toDto(Room room);
    Room toEntity(RoomDTO roomDTO);
    List<RoomDTO> toDtoList(List<Room> rooms);
    List<Room> toEntityList(List<RoomDTO> roomDTOs);
}