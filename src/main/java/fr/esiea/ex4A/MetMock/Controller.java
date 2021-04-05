package fr.esiea.ex4A.MetMock;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    private final UserRepository userRepository;
    private final List<UserInfo> userListe = new ArrayList<>();

    Controller(UserRepository userRepository){this.userRepository = userRepository;}

    @PostMapping(path = "/api/inscription")
    String Inscription(@RequestBody UserInfo info) {
        userListe.add(info);
        return "Sucess";
    }

    @GetMapping(path = "/api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MatcheInfo> Matches(@RequestParam String userName, @RequestParam String userCountry){
        final List<MatcheInfo> matcheList = new ArrayList<>();
        UserInfo currentUserInfo = getUser(userName);
        for (UserInfo userInfo : userListe) {
            if (!userName.equals(userInfo.getUserName()) && userCountry.equals(userInfo.getUserCountry())) {
                if (currentUserInfo.getUserSexPref().equals(userInfo.getUserSex()))
                    matcheList.add(new MatcheInfo(userInfo.getUserName(), userInfo.getUserTweeter()));
            }
        }
        return matcheList;
    }

    UserInfo getUser(String userName){
        UserInfo info = null;
        for (UserInfo userInfo : userListe) {
            if(userName.equals(userInfo.getUserName())){
                info = userInfo;
                break;
            }
        }
        return info;
    }
}
