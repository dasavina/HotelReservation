package hotelreservation.customers.Clients;


import hotelreservation.customers.Dtos.RoomDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

// URL або ім'я служби
@FeignClient(name = "room-service", url = "http://localhost:8081/api/rooms")
public interface RoomClient {

@RequestMapping(method = RequestMethod.GET)
    List<RoomDTO> getRooms();
}

