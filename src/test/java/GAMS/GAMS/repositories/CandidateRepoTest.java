package GAMS.GAMS.repositories;

import GAMS.Crudrepository.CandidateRepo;
import GAMS.Crudrepository.EndUserRepo;
import GAMS.Crudrepository.StudentRepo;
import GAMS.entity.Candidate;
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

public class CandidateRepoTest {

    @Autowired
    private CandidateRepo candidateRepo;

    @Test
    public void CreateCheck() {

        Candidate candidate = new Candidate("email","decision");
        candidateRepo.save(candidate);
        Assert.assertNotNull(candidateRepo.findAll());
    }
}




