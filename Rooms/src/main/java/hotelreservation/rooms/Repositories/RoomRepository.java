package hotelreservation.rooms.Repositories;

import hotelreservation.rooms.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {}

