package GAMS.GAMS.models;

import GAMS.entity.Email;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailTest {
    Email email = new Email("prof1", "student1");

    @Test
    public void getToField() {
        assertEquals("prof1", email.getToField());
    }

    @Test
    public void setToField() {
        email.setToField("prof2");
        assertEquals("prof2", email.getToField());
    }

    @Test
    public void getFromField() {
        assertEquals("student1", email.getFromField());
    }

    @Test
    public void setFromField() {
        email.setFromField("student2");
        assertEquals("student2", email.getFromField());
    }

    @Test
    public void isRead() {
        assertFalse(email.isRead());
    }

    @Test
    public void markRead() {
        email.markRead(true);
        assertTrue(email.isRead());
    }

}