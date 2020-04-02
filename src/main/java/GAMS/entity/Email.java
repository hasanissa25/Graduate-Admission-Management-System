package GAMS.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String toField;

    @NotNull
    private String fromField;

    @NotNull
    private Boolean readFlag;

    public Email() {
    }

    public Email(String to, String from) {
        this.toField = to;
        this.fromField = from;
        this.readFlag = false;
    }

    public void setToField(String toField) {
        this.toField = toField;
    }

    public String getToField() {
        return toField;
    }

    public void setFromField(String fromField) {
        this.fromField = fromField;
    }

    public String getFromField() {
        return fromField;
    }

    public void markRead(Boolean read) {
        readFlag = read;
    }

    public Boolean isRead() {
        return readFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
