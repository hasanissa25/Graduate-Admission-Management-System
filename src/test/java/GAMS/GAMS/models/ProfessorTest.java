package GAMS.GAMS.models;

import GAMS.entity.EndUser;
import GAMS.entity.FieldOfResearch;
import GAMS.entity.Professor;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProfessorTest {
    ArrayList<FieldOfResearch> fieldOfResearches = new ArrayList<>();
    Professor prof = new Professor("","","","",fieldOfResearches);

    @Test
    public void testResearch() {
        assertEquals(fieldOfResearches, prof.getResearch());
    }

    @Test
    public void testStudentsList() {
        prof.setEmailAddress("noemail@email.com");
        assertEquals("noemail@email.com", prof.getEmailAddress());
    }

}