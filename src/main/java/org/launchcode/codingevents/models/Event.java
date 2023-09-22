package org.launchcode.codingevents.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
@Entity
public class Event {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message="Name is required")
    @Size(min=3, max = 50, message="Name must be between 3 and 50 characters")
    private String name;
    @Size(max=500, message="Description is too long")
    private String description;
    @NotBlank(message = "E-mail required")
    @Email(message="Invalid E-mail")
    private String contactEmail;


    private EventType type;

    public Event(String name, String description,
                 String contactEmail,  EventType type) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.contactEmail=contactEmail;

    }
    public Event(){}

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public EventType getType() {
        return type;
    }



    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }


    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
