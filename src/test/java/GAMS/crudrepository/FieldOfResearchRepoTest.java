package GAMS.crudrepository;

import GAMS.Crudrepository.FieldOfResearchRepo;
import GAMS.entity.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FieldOfResearchRepoTest {

    @Autowired
    private FieldOfResearchRepo research;

    @Test
    public void findByNameTest() {
        FieldOfResearch project1 = new FieldOfResearch();
        ArrayList<FieldOfResearch> projects = new ArrayList<>();
        projects.add(project1);

       Professor prof = new Professor("","","",projects);
        FieldOfResearch project = new FieldOfResearch("sysc4806","lab", prof );
        research.save(project);
        Assert.assertNotNull(research.findAll());
    }


}