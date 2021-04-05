package fr.esiea.ex4A.MetMock;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class UserRepositoryTest {

    @Test
    void useer() {
        UserRepository repo = new UserRepository();
        UserInfo userInfo = new UserInfo("test@et.fr", "Test", "testset", "FR", "M", "F");
        MatcheInfo matcheInfo = new MatcheInfo("Betty", "Bett");
        Assertions.assertThat(repo.MatcheUser(userInfo).getName()).isEqualTo(matcheInfo.getName());
    }
}
