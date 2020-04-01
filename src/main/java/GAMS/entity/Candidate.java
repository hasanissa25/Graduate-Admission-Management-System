package GAMS.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Candidate  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String decision;
    private String email;
    private String final_decision;

    public String getFinal_decision() {
        return final_decision;
    }

    public void setFinal_decision(String final_decision) {
        this.final_decision = final_decision;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Candidate(String email, String decision, String final_decision) {

        this.decision =decision;
        this.email = email;
        this.final_decision = final_decision;
    }

    public Candidate() {

    }



}
