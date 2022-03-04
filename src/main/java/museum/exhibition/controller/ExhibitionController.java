package museum.exhibition.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import museum.exhibition.domain.User;
import museum.exhibition.domain.exhibitionInfo.Info;
import museum.exhibition.jsonApi.OpenApi;
import museum.exhibition.repository.ReservationRepository;
import museum.exhibition.repository.UserRepository.UserRepository;
import museum.exhibition.web.JoinDto;
import museum.exhibition.web.UserLoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@RequiredArgsConstructor
@Controller
public class ExhibitionController {

    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;
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
    public String memberJoin(@ModelAttribute JoinDto joinDto) {
        return "joinForm";
    }

    @PostMapping("/join")
    public String memberJoin2(@ModelAttribute JoinDto joinDto) {
        User user = new User(joinDto.getName(), joinDto.getLoginId(), joinDto.getPassword(), joinDto.getEmail());

        userRepository.save(user);
        return "redirec:/";
    }

}
