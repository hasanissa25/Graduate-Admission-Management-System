package GAMS.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Professor extends EndUser implements Serializable {
    //List of researches conducted by this professor
    private ArrayList<FieldOfResearch> fieldOfResearches;

    public Professor(String username, String password, String confPassword, String email, ArrayList<FieldOfResearch> fieldOfResearches) {
        super(username, password, confPassword, email, Role.PROFESSOR);
        this.fieldOfResearches = fieldOfResearches ;
    }

    public ArrayList<FieldOfResearch> getResearch() {
        return fieldOfResearches;
    }

    public void setResearchs(ArrayList<FieldOfResearch> researchs) {
        this.fieldOfResearches = fieldOfResearches;
    }
}
