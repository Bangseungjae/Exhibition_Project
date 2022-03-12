package museum.exhibition.service;

import lombok.RequiredArgsConstructor;
import museum.exhibition.domain.Reservation;
import museum.exhibition.domain.User;
import museum.exhibition.repository.reservationRePository.ReservationRepository;
import museum.exhibition.web.ReservationDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public Long save(ReservationDto reservationDto, User user) {
        Reservation reservation = new Reservation(reservationDto, user);
        return reservationRepository.save(reservation).getId();
    }

    public void delete(Long id) {
        Reservation reservation = reservationRepository
                .findById(id).orElseThrow(() -> new IllegalArgumentException("해당 예약이 없습니다."));
        reservationRepository.delete(reservation);
    }

    public ReservationDto findById(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id 예약이 없습니다."));
        return new ReservationDto(reservation);
    }

    @Transactional(readOnly = true)
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Reservation> findByUser(User user){
        return reservationRepository.findReservationsByUser(user);


    }
}
