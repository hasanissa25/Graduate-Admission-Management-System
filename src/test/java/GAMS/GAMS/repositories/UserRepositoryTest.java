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
    private EndUser user;

    @Test
    public void CreateStudentCheckRepoistory() {
        EndUser user = new EndUser("Student", "pass", "pass", "pass",EndUser.Role.STUDENT);
        endUserRepo.save(user);
        Assert.assertNotNull(endUserRepo.findByUsername("Student"));
    }
    @Test
    public void CreateProfessorCheckRepoistory() {
        EndUser user = new EndUser("Professor", "pass", "pass", "pass", EndUser.Role.PROFESSOR);
        endUserRepo.save(user);
        Assert.assertNotNull(endUserRepo.findByUsername("Professor"));
    }
    @Test
    public void CreateAdministratorCheckRepoistory() {
        EndUser user = new EndUser("Admin", "pass", "pass", "pass" ,EndUser.Role.ADMINISTRATOR);
        endUserRepo.save(user);
        Assert.assertNotNull(endUserRepo.findByUsername("Admin"));
    }
}


