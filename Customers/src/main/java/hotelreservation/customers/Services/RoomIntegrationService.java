package hotelreservation.customers.Services;

import hotelreservation.customers.Clients.RoomClient;
import hotelreservation.customers.Dtos.RoomDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomIntegrationService {

    private final RoomClient roomClient;

    public RoomIntegrationService(RoomClient roomClient) {
        this.roomClient = roomClient;
    }

    public List<RoomDTO> fetchAvailableRooms() {
        return roomClient.getRooms();
    }
}

