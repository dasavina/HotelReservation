package hotelreservation.reservations.Services;

import hotelreservation.reservations.Dtos.ReservationDTO;
import hotelreservation.reservations.Dtos.ReservationMapper;
import hotelreservation.reservations.Entities.Reservation;
import hotelreservation.reservations.Repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    public ReservationService(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    public List<ReservationDTO> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservationMapper.toDtoList(reservations);
    }

    public ReservationDTO getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        return reservationMapper.toDto(reservation);
    }

    public ReservationDTO createReservation(ReservationDTO reservationDTO) {
        Reservation reservation = reservationMapper.toEntity(reservationDTO);
        Reservation savedReservation = reservationRepository.save(reservation);
        return reservationMapper.toDto(savedReservation);
    }

    public ReservationDTO updateReservation(Long id, ReservationDTO reservationDTO) {
        Reservation existingReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        existingReservation.setCustomerId(reservationDTO.getCustomerId());
        existingReservation.setRoomId(reservationDTO.getRoomId());
        existingReservation.setCheckInDate(reservationDTO.getCheckInDate());
        existingReservation.setCheckOutDate(reservationDTO.getCheckOutDate());
        Reservation updatedReservation = reservationRepository.save(existingReservation);
        return reservationMapper.toDto(updatedReservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}

