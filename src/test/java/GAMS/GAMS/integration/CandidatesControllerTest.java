package GAMS.GAMS.integration;

import GAMS.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

    @RunWith(SpringRunner.class)
    @SpringBootTest(classes = Application.class , webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
    @AutoConfigureMockMvc
    public class CandidatesControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        WebApplicationContext context;

        @Test
        public void CandidatesControllerProfile() throws Exception {
            mockMvc.perform(post("/register")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .param("role", "PROFESSOR")
                    .param("username", "testName")
                    .param("password", "testpass")
                    .param("confPassword", "testpass")
            ).andDo(print())
                    .andExpect(status().is2xxSuccessful())
                    .andExpect(view().name("layout"));

            mockMvc.perform(post("/login")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .param("username", "testUser")
                    .param("password", "testpass")
            ).andDo(print())
                    .andExpect(status().is3xxRedirection());

            mockMvc.perform(get("/StudentCandidate")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            ).andDo(print())
                    .andExpect(status().is3xxRedirection())
                    .andExpect(content().string(containsString(""))); // when we open in the starting; the body should be null
        }

        @Test
        public void CandidatesPost() throws Exception {
            mockMvc.perform(post("/register")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .param("role", "PROFESSOR")
                    .param("username", "testName")
                    .param("password", "testpass")
                    .param("confPassword", "testpass")
            ).andDo(print())
                    .andExpect(status().is3xxRedirection())
                    .andExpect(view().name("redirect:login"));

            mockMvc.perform(post("/login")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .param("username", "testUser")
                    .param("password", "testpass")
            ).andDo(print())
                    .andExpect(status().is3xxRedirection());

            mockMvc.perform(post("/StudentCandidate")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .param("email", "testemail")
                    .param("decision", "decision")

            ).andDo(print())
                    .andExpect(status().is3xxRedirection());


        }
    }

