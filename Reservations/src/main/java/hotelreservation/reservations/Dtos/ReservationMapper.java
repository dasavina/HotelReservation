package hotelreservation.reservations.Dtos;

import hotelreservation.reservations.Entities.Reservation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    ReservationDTO toDto(Reservation reservation);
    Reservation toEntity(ReservationDTO reservationDTO);
    List<ReservationDTO> toDtoList(List<Reservation> reservations);
    List<Reservation> toEntityList(List<ReservationDTO> reservationDTOs);
}
