package GAMS.GAMS.repositories;

import GAMS.Crudrepository.EmailRepo;
import GAMS.entity.Email;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailRepoTest {

    @Autowired
    private EmailRepo emailRepo;

    @Test
    public void CreateCheck() {

        Email email1 = new Email("prof1", "student1");
        emailRepo.save(email1);
        Email email2 = new Email("prof1", "student2");
        emailRepo.save(email2);
        Assert.assertNotNull(emailRepo.findAllByToField("prof1"));
    }
}




