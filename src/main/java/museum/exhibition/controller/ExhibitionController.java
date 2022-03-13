package museum.exhibition.controller;

import lombok.RequiredArgsConstructor;
import museum.exhibition.domain.User;
import museum.exhibition.domain.exhibitionInfo.Info;
import museum.exhibition.jsonApi.OpenApi;
import museum.exhibition.service.ReservationService;
import museum.exhibition.service.UserService;
import museum.exhibition.web.JoinDto;
import museum.exhibition.web.ReservationDto;
import museum.exhibition.web.UserLoginDto;
import museum.exhibition.web.UserWebDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ExhibitionController {

    private final UserService userService;
    private final ReservationService reservationService;
    private final OpenApi openApi;

    @GetMapping("/")
    public String index(@ModelAttribute("loginDto") UserLoginDto loginDto, Model model) throws IOException {
        Info[] infos = openApi.getInfos("1");
        model.addAttribute("infos", infos);
        return "index";
    }

    @GetMapping("/test")
    public String test(@ModelAttribute("loginDto") UserLoginDto loginDto, Model model) throws IOException {
        Info[] infos = openApi.getInfos("1");
        model.addAttribute("infos", infos);
        return "test";
    }

    @GetMapping("/join")
    public String memberJoin(@ModelAttribute("joinDto") JoinDto joinDto) {
        return "joinForm";
    }

    @PostMapping("/join")
    public String memberJoinPost(@ModelAttribute("joinDto") JoinDto joinDto) {
        User user = new User(joinDto.getName(), joinDto.getLoginId(), joinDto.getPassword(), joinDto.getEmail());
        userService.save(user);
        return "redirect:/";
    }

    @PostMapping("/")
    public String login(@ModelAttribute("loginDto") UserLoginDto userLoginDto, Model model) throws IOException {
        Info[] infos = openApi.getInfos("1");
        model.addAttribute("infos", infos);
        User user = userService.findUserByLogin(userLoginDto);
        if (user == null) {
            return "index";
        }else{
            UserWebDto userWebDto = new UserWebDto(user, user.getReservations());
            model.addAttribute("userWebDto", userWebDto);

            return "userHome";
        }
    }
}
