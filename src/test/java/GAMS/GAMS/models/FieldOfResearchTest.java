package GAMS.GAMS.models;

import GAMS.entity.EndUser;
import GAMS.entity.FieldOfResearch;
import GAMS.entity.Professor;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FieldOfResearchTest {
    ArrayList<FieldOfResearch> fieldOfResearches = new ArrayList<>();
    ArrayList<EndUser> students = new ArrayList<>();
    Professor prof = new Professor("","","","",fieldOfResearches);
    FieldOfResearch for1 = new FieldOfResearch("","", prof);
    FieldOfResearch for2 = new FieldOfResearch("","", 0, prof, students);

    @Test
    public void testName() {
        for1.setName("Tash");
        assertEquals("Tash", for1.getName());
    }
    @Test
    public void testDescription() {
        for1.setDescription("description");
        assertEquals("description", for1.getDescription());
    }
    @Test
    public void testNumberOfStudents() {
        for2.setNumberStudents(10);
        assertEquals(10 , for2.getNumberStudents());
    }

    @Test
    public void testProfessor() {
        Professor prof = new Professor("noemail@email.com","","","",fieldOfResearches);
        for2.setProfessor(prof);
        assertEquals(prof, for2.getProfessor());
    }

    @Test
    public void testStudentsList() {
        EndUser enduser = new EndUser("Tash","pass", "pass", EndUser.Role.STUDENT);
        ArrayList<EndUser> students = new ArrayList<>();
        students.add(enduser);
        for2.setStudents(students);
        assertEquals(students, for2.getStudents());
    }

    @Test
    public void testAddStudent() {
        EndUser e = new EndUser("Tash","pass", "pass", EndUser.Role.STUDENT);
        assertEquals(true, for2.addStudent(e));
    }

    @Test
    public void testHasStudent() {
        String s = "Tash";
        EndUser e = new EndUser("Tash","pass", "pass", EndUser.Role.STUDENT);
        for2.addStudent(e);
        assertEquals(true, for2.hasStudent(s));
    }

}