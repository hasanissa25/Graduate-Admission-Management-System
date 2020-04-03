package GAMS.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Student extends EndUser implements Serializable {


    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public enum Assessment {
        C1("Don’t recommend for admission"),
        C2("Recommend but not interested in supervision"),
        C3("Recommend but no funding"),
        C4("Recommend and yes to funding");

        public String getValue() {
            return value;
        }

        private final String value;

        Assessment(String value){
            this.value=value;
        }

    }

    private String email;
    private String cv;
    private String diploma;
    private String gradeAudit;
    private String decision;
    private Assessment assessment;
    private Boolean hasFOR;
    private Boolean hasProfile;

    public Student() {
        super();
        this.hasFOR = false;
        this.hasProfile = false;
        setRole(Role.STUDENT);
    }

    public Student(String username, String password, String confPassword) {
        super(username, password, confPassword, Role.STUDENT);
        this.hasFOR = false;
        this.hasProfile = false;
    }

    public Student(String username, String password, String confPassword, String email,
                   String cv, String diploma, String gradeAudit) {
        super(username, password, confPassword, Role.STUDENT);
        this.email = email;
        this.cv = cv;
        this.diploma = diploma;
        this.gradeAudit = gradeAudit;
        this.hasFOR = false;
        this.hasProfile = false;
    }

    public Student(String username, String password, String confPassword, String email,
                   Assessment assessment) {
        super(username, password, confPassword, Role.STUDENT);
        this.email = email;
        this.assessment = assessment;
        this.hasFOR = false;
        this.hasProfile = false;
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

    public Assessment getAssessment(){
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    public Boolean getHasFOR() {
        return hasFOR;
    }

    public void setHasFOR(Boolean hasFOR) {
        this.hasFOR = hasFOR;
    }

    public Boolean getHasProfile() {
        return hasProfile;
    }

    public void setHasProfile(Boolean hasProfile) {
        this.hasProfile = hasProfile;
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
