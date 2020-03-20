package GAMS.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class FieldOfResearch implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    //Maximum Number of students
    private int numberStudents;

    // Increased Column Size due to serialized objects
    @Column(length=1024)
    private Professor professor;

    @Column(length=1024)
    private ArrayList<EndUser> students;

    private String emailAddress;

    public FieldOfResearch(String name,String description,Professor professor) {
        this.name = name;
        this.description=description;
        this.professor=professor;

    }

    private enum Status {ACTIVE, INACTIVE}
    private Status status;

    public FieldOfResearch() {

    }

    public FieldOfResearch(String name, String description, int numberStudents, Professor professor, ArrayList<EndUser> students) {
        this.name = name;
        this.description = description;
        this.numberStudents = numberStudents;
        this.professor = professor;
        this.students = students;

        this.status = Status.ACTIVE;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberStudents() {
        return numberStudents;
    }

    public void setNumberStudents(int numberStudents) {
        this.numberStudents = numberStudents;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public ArrayList<EndUser> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<EndUser> students) {
        this.students = students;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public boolean hasStudent(String name) {
        for(EndUser user: this.students) {
            if (user.getUsername().equals(name)) {
                return true;
            }
        }
         return false;
    }


    public boolean addStudent(EndUser student){

        for (EndUser s : students) {
            if (s.getUsername().equals(student.getUsername())) {
                return false;
            }
        }
        this.students.add(student);
        return true;
    }

    public void activate(){
        this.status = Status.ACTIVE;
    }

    public void deactivate(){
        this.status = Status.INACTIVE;
    }

    public boolean isActive(){
        return this.status == Status.ACTIVE;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}

