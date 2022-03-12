package museum.exhibition.controller;

import lombok.RequiredArgsConstructor;
import museum.exhibition.domain.Reservation;
import museum.exhibition.domain.User;
import museum.exhibition.domain.exhibitionInfo.Info;
import museum.exhibition.jsonApi.OpenApi;
import museum.exhibition.service.ReservationService;
import museum.exhibition.service.UserService;
import museum.exhibition.web.JoinDto;
import museum.exhibition.web.ReservationDto;
import museum.exhibition.web.UserLoginDto;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ApiController {
    private final OpenApi api;
    private final UserService userService;
    private final ReservationService reservationService;

    @GetMapping("/study/{page}")
    public Info[] getExhibitionInfo(@PathVariable String page) throws IOException {
        return api.getInfos(page);
    }

    @PostMapping("/user/reservations/{id}")
    public Long addReservation(@RequestBody ReservationDto reservationDto, @PathVariable Long id) {
        System.out.println("id = " + id);
        System.out.println("reservationDto = " + reservationDto);
        User user = userService.findUserbyId(id);
        return reservationService.save(reservationDto, user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteReservation(@PathVariable Long id, @RequestBody ReservationDto reservationDto) {
        System.out.println("reservationDto = " + reservationDto.getId());
        reservationService.delete(reservationDto.getId());
//        User userbyId = userService.findUserbyId(id);
//        List<Reservation> byUser = reservationService.findByUser(userbyId);

//        System.out.println("reservations = " + byUser);
//        System.out.println("reservationDto = " + reservationDto);
//        for (Reservation reservation : byUser) {
//            if (reservationDto.getTitle().equals(reservation.getTitle())){
//                reservationService.delete(reservation.getId());
//            }
//        }
    }

    @GetMapping("/user")
    public List<ReservationDto> findReservationsByUser(UserLoginDto userLoginDto) {
        User user = userService.findUserByLogin(userLoginDto);
        List<Reservation> reservations = reservationService.findByUser(user);
        List<ReservationDto> reservationDtos = new ArrayList<>();
        for (Reservation reservation : reservations) {
            reservationDtos.add(new ReservationDto(reservation));
        }
            return reservationDtos;
    }

    @PostMapping("/user/save")
    public Long userSave(@RequestBody JoinDto joinDto){
        User user = new User(joinDto.getName(), joinDto.getLoginId(), joinDto.getPassword(), joinDto.getEmail());
        Long save = userService.save(user);
        return save;
    }
}
