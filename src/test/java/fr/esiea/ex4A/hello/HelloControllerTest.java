package fr.esiea.ex4A.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class HelloControllerTest {

    private final MockMvc mockMvc;

    @MockBean
    private HelloController controller;

    HelloControllerTest(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void sayHello_when_name_param_is_present() throws Exception{
        when(controller.sayHello(any())).thenReturn(new HelloData("test"));

        mockMvc
            .perform(MockMvcRequestBuilders.get("/hello?name=test"))
            .andExpect(status().isOk())
            .andExpect(content().json("""
                        {
                            "type":"hello",
                            "name":"test",
                            "completeSentence":"hello test!"}
                        }
                        """));

        verify(controller).sayHello("test");
    }

}
