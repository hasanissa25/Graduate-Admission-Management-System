package GAMS.GAMS.models;

import GAMS.entity.Student;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentTest {
    Student student = new Student("Sarah","pass1", "pass1",
            "email1", "cv1", "diploma1", "gradeAudit1");

    @Test
    public void getEmail() {
        assertEquals("email1", student.getEmail());
    }

    @Test
    public void setEmail() {
        student.setEmail("email2");
        assertEquals("email2", student.getEmail());
    }

    @Test
    public void getCV() {
        assertEquals("cv1", student.getCv());
    }

    @Test
    public void setCv() {
        student.setCv("cv2");
        assertEquals("cv2", student.getCv());
    }

    @Test
    public void getDiploma() {
        assertEquals("diploma1", student.getDiploma());
    }

    @Test
    public void setDiploma() {
        student.setDiploma("diploma2");
        assertEquals("diploma2", student.getDiploma());
    }

    @Test
    public void getGradeAudit() {
        assertEquals("gradeAudit1", student.getGradeAudit());
    }

    @Test
    public void setGradeAudit() {
        student.setGradeAudit("gradeAudit2");
        assertEquals("gradeAudit2", student.getGradeAudit());
    }
}
