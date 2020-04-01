package GAMS.GAMS.models;

import GAMS.entity.Candidate;
import GAMS.entity.Student;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CandidateTest {
    Candidate candidate = new Candidate("email","decision");

    @Test
    public void getEmail() {
        assertEquals("email", candidate.getEmail());
    }

    @Test
    public void setEmail() {
        candidate.setEmail("email2");
        assertEquals("email2", candidate.getEmail());
    }

    @Test
    public void getDecision() {
        assertEquals("decision", candidate.getDecision());
    }

    @Test
    public void setDecision() {
        candidate.setDecision("Decision2");
        assertEquals("Decision2", candidate.getDecision());
    }
}
