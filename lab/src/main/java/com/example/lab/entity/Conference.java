package com.example.lab.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="conferences")
public class Conference extends Event {

    @OneToMany(cascade = CascadeType.ALL)
    List<Speaker> speakers;

    public Conference(String title, LocalDate date, Integer duration, String location, List<Speaker> speakers) {
        super(title, date, duration, location);
        this.speakers = speakers;
    }

    public Conference() {

    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }
}