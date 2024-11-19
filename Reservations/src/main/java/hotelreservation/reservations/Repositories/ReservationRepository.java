package hotelreservation.reservations.Repositories;



import hotelreservation.reservations.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {}
