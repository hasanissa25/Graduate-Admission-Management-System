package GAMS.GAMS.repositories;

import GAMS.Crudrepository.StudentRepo;
import GAMS.entity.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepo studentRepo;

    @Test
    public void findByUsername() {
        Student student = new Student("Sarah","pass1", "pass1",
                "email1", "cv1", "diploma1", "gradeAudit1");
        studentRepo.save(student);
        Assert.assertNotNull(studentRepo.findByUsername("Sarah"));
    }
}



