package GAMS.GAMS.repositories;


import GAMS.Crudrepository.EndUserRepo;
import GAMS.entity.EndUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private EndUserRepo endUserRepo;

    @Test
    public void findByUsernameTest() {
        EndUser user = new EndUser("Hasan", "pass", "pass", EndUser.Role.STUDENT);
        endUserRepo.save(user);
        Assert.assertNotNull(endUserRepo.findByUsername("Hasan"));
    }
}


