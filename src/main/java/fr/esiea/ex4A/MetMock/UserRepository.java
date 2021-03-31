package fr.esiea.ex4A.MetMock;

import fr.esiea.ex4A.hello.HelloData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository
public class UserRepository {

    final List<UserInfo> user = List.of(
        new UserInfo("marc@ino.fr","Marc","marc76","FR","M","F"),
        new UserInfo("julie@ino.fr","Julie","juju","FR","F","M"),
        new UserInfo("jean@ino.fr","Jean","JeanDu93","FR","M","F"),
        new UserInfo("micheal@ino.fr","Micheal","mick","US","M","M"),
        new UserInfo("betty@ino.fr","Betty","Bett","FR","F","F")
    );

    private final Random random = new Random();

    MatcheInfo MatcheUser(UserInfo CurrentUserInfo) {
        MatcheInfo matcheInfo = null;
        for (UserInfo userInfo : user) {
            if (!CurrentUserInfo.getUserName().equals(userInfo.getUserName()) && CurrentUserInfo.getUserCountry().equals(userInfo.getUserCountry())) {
                if (CurrentUserInfo.getUserSexPref().equals(userInfo.getUserSex()))
                    matcheInfo = new MatcheInfo(userInfo.getUserName(), userInfo.getUserTweeter());
            }
        }
        return matcheInfo;
    }
}
