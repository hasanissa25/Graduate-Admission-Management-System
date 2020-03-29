package GAMS.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class Student extends EndUser implements Serializable {


    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public enum Assessment {
        C1, C2, C3, C4
    }
    private Assessment assessment;

    private String email;
    private String cv;
    private String diploma;
    private String gradeAudit;
    private String decision;

    public Student() {
        super();
        setRole(Role.STUDENT);
    }

    public Student(String username, String password, String confPassword) {
        super(username, password, confPassword, Role.STUDENT);
    }

    public Student(String username, String password, String confPassword, String email,
                   String cv, String diploma, String gradeAudit) {
        super(username, password, confPassword, Role.STUDENT);
        this.email = email;
        this.cv = cv;
        this.diploma = diploma;
        this.gradeAudit = gradeAudit;
    }

    public Student(String username, String password, String confPassword, String email, String decision) {
        super(username, password, confPassword, Role.STUDENT);
        this.email = email;
        this.decision = decision;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setGradeAudit(String gradeAudit) {
        this.gradeAudit = gradeAudit;
    }

    public String getGradeAudit() {
        return gradeAudit;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getCv() {
        return cv;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getDecision() {
        return decision;
    }

    public String getAssessment(){

        switch(assessment) {
            case C1:
                return "Don’t recommend for admission";
            case C2:
                return "Recommend but not interested in supervision";
            case C3:
                return "Recommend but no funding";
            case C4:
                return "Recommend and yes to funding";
        }
        return assessment.name();
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
