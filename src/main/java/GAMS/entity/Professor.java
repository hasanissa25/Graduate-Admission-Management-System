package GAMS.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Professor extends EndUser implements Serializable {
    //List of researches conducted by this professor
    private ArrayList<FieldOfResearch> fieldOfResearches;
    private String emailAddress;


    public Professor(String emailAddress,String username, String password, String confPassword, ArrayList<FieldOfResearch> fieldOfResearches) {
        super(username, password, confPassword, Role.PROFESSOR);
        this.fieldOfResearches = fieldOfResearches ;
        this.emailAddress=emailAddress;
    }

    public ArrayList<FieldOfResearch> getResearch() {
        return fieldOfResearches;
    }

    public void setResearchs(ArrayList<FieldOfResearch> researchs) {
        this.fieldOfResearches = fieldOfResearches;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
