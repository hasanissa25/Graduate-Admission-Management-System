package GAMS.GAMS.models;

import GAMS.entity.EndUser;
import org.junit.Test;
import static org.junit.Assert.*;

public class EndUserTest {

    EndUser user = new EndUser("Hasan","pass", "pass",  EndUser.Role.STUDENT);

    @Test
    public void getUsername() {
        assertEquals("Hasan",user.getUsername());
    }

    @Test
    public void setUsername() {
        user.setUsername("Hasan1995");
        assertEquals("Hasan1995",user.getUsername());
    }

    @Test
    public void getPassword() {
        assertEquals("pass",user.getPassword());
    }

    @Test
    public void setPassword() {
        user.setPassword("password");
        assertEquals("password",user.getPassword());
    }


    @Test
    public void getRole() {
        assertEquals(EndUser.Role.STUDENT, user.getRole());

    }

    @Test
    public void setRole() {
        user.setRole(EndUser.Role.STUDENT);
        assertEquals(EndUser.Role.STUDENT,user.getRole());
    }
}