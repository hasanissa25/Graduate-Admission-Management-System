package GAMS.GAMS.models;

import GAMS.entity.EndUser;
import org.junit.Test;
import static org.junit.Assert.*;

public class EndUserTest {

    EndUser student = new EndUser("Hasan","pass", "pass", "pass", EndUser.Role.STUDENT);
    EndUser prof = new EndUser("prof","pass", "pass", "pass", EndUser.Role.PROFESSOR);
    EndUser admin = new EndUser("admin","pass", "pass", "pass",  EndUser.Role.ADMINISTRATOR);

    @Test
    public void testStudentUserName() {
        assertEquals("Hasan",student.getUsername());
    }
    @Test
    public void testProfUserName() {
        assertEquals("prof",prof.getUsername());
    }
    @Test
    public void testAdminUserName() {
        assertEquals("admin",admin.getUsername());
    }

    @Test
    public void setStudentUserName() {
        student.setUsername("HasanModified");
        assertEquals("HasanModified",student.getUsername());
    }
    @Test
    public void setProfUserName() {
        prof.setUsername("profModified");
        assertEquals("profModified",prof.getUsername());
    }
    @Test
    public void setAdminUserName() {
        admin.setUsername("adminModified");
        assertEquals("adminModified",admin.getUsername());
    }

    @Test
    public void getStudentPassword() {
        assertEquals("pass",student.getPassword());
    }
    @Test
    public void getProfPassword() {
        assertEquals("pass",prof.getPassword());
    }
    @Test
    public void getAdminPassword() {
        assertEquals("pass",admin.getPassword());
    }

    @Test
    public void setStudentPassword() {
        student.setPassword("password");
        assertEquals("password",student.getPassword());
    }
    @Test
    public void setProfPassword() {
        prof.setPassword("password");
        assertEquals("password",prof.getPassword());
    }
    @Test
    public void setAdminPassword() {
        admin.setPassword("password");
        assertEquals("password",admin.getPassword());
    }


    @Test
    public void getStudentRole() {
        assertEquals(EndUser.Role.STUDENT, student.getRole());
    }
    @Test
    public void getProfRole() {
        assertEquals(EndUser.Role.PROFESSOR, prof.getRole());
    }
    @Test
    public void getAdminRole() {
        assertEquals(EndUser.Role.ADMINISTRATOR, admin.getRole());
    }

    @Test
    public void setRoleToStudent() {
        student.setRole(EndUser.Role.STUDENT);
        assertEquals(EndUser.Role.STUDENT,student.getRole());
    }
    @Test
    public void setRoleToProf() {
        student.setRole(EndUser.Role.PROFESSOR);
        assertEquals(EndUser.Role.PROFESSOR,prof.getRole());
    }
    @Test
    public void setRoleToAdmin() {
        student.setRole(EndUser.Role.ADMINISTRATOR);
        assertEquals(EndUser.Role.ADMINISTRATOR,admin.getRole());
    }
}