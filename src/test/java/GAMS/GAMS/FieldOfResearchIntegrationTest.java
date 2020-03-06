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

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class , webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class FieldOfResearchIntegrationTest {
    @Autowired
    MockMvc mockMvc;
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
    public void viewCurrentFieldOfStudy() throws Exception {

        this.mockMvc.perform(get("/createFOR")).andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("layout"))
                .andExpect(model().attribute("user", hasProperty("name", nullValue())))
                .andExpect(model().attribute("user", hasProperty("description", nullValue())));
    }

    @Test
    public void createFieldOfStudy() throws Exception {

    }

    @Test
    public void DeleteFieldOfStudy() throws Exception {
        mockMvc.perform(post("/fieldOfResearch")

                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("delete", "delresearch")

        ).andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:fieldOfResearch"));
    }

//    @SpringBootTest
//    @AutoConfigureMockMvc
//    public class AddressBookApplicationTests {
//
//        @Autowired
//        private MockMvc mockMvc;
//
//        @Test
//        public void shouldReturnDefaultMessage() throws Exception {
//            this.mockMvc.perform(get("/1")).andDo(print()).andExpect(status().isOk());
//        }
//    }
}
