package fr.esiea.ex4A.MetMock;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class ControllerTest {

    private final MockMvc mockMvc;

    @MockBean
    private Controller controller;

    ControllerTest(@Autowired MockMvc mockMvc){
        this.mockMvc = mockMvc;
    }

    @Test
    void testOneUser() {
        final List<UserInfo> userListe = new ArrayList<>();
        UserInfo userInfo = new UserInfo("test@et.fr", "Test", "testset", "FR", "M", "F");
        userListe.add(userInfo);
        Assertions.assertThat(userListe.size()).isEqualTo(1);
    }

    @Test
    void testMoreUser() {
        final List<UserInfo> userListe = new ArrayList<>();
        UserInfo userInfo = new UserInfo("test@et.fr", "Test", "testset", "FR", "M", "F");
        UserInfo userInfo2 = new UserInfo("test2@et.fr", "Test2", "testset2", "FR", "M", "F");
        UserInfo userInfo3 = new UserInfo("test3@et.fr", "Test3", "testset3", "FR", "M", "F");
        userListe.add(userInfo);
        userListe.add(userInfo2);
        userListe.add(userInfo3);
        Assertions.assertThat(userListe.size()).isEqualTo(3);
    }

}
