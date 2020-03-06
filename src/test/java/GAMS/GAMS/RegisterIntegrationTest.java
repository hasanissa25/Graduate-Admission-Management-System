package GAMS.GAMS;

import GAMS.Application;
import GAMS.entity.EndUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.nullValue;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class , webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class RegisterIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    WebApplicationContext context;


    @Test
    public void navigateToResgistrationFormSuccessfully() throws Exception {
        this.mockMvc.perform(get("/register")).andDo(print()).andExpect(status().isOk())
        .andExpect(view().name("layout"))
                .andExpect(model().attribute("user", hasProperty("username", nullValue())))
                .andExpect(model().attribute("user", hasProperty("password", nullValue())))
                .andExpect(model().attribute("user", hasProperty("confPassword", nullValue())));
        }


    @Test
    public void submitStudentRegisterationWithValidData() throws Exception {
        mockMvc.perform(post("/register")

                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("role", "STUDENT")
                .param("username", "testUserName")
                .param("password", "testpassword")
                .param("confPassword", "testpassword")


        ).andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:login"));
    }
    }
