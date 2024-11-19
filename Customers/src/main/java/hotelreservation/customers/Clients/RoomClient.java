package hotelreservation.customers.Clients;

import hotelreservation.rooms.Dtos.RoomDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

// URL або ім'я служби
@FeignClient(name = "room-service", url = "http://localhost:8081/api/rooms")
public interface RoomClient {

    @GetMapping
    List<RoomDTO> getAllRooms();
}

