package GAMS.GAMS.repositories;

import GAMS.Crudrepository.EndUserRepo;
import GAMS.Crudrepository.StudentRepo;
import GAMS.entity.EndUser;
import GAMS.entity.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class StudentRepoTest {

    @Autowired
    private StudentRepo studentRepo;

    @Test
    public void CreateCheck() {

        Student student1 = new Student("aman","pass","pass","email","cv","diploma","gradeAudit");
        studentRepo.save(student1);
        Assert.assertNotNull(studentRepo.findByUsername("aman"));
    }
}




