package com.example.demo;

import javax.persistence.*;
import java.time.LocalDate;


import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Note")
public class Note implements Comparable {

    @Id
    @SequenceGenerator(
            name = "note_sequence",
            sequenceName = "note_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "note_sequence"
    )

    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "date",
            nullable = false
    )
    private LocalDate date;

    @Column(
            name = "headline",
            columnDefinition = "Text"
    )
    private String headline;

    @Column(
            name = "text",
            columnDefinition = "Text"
    )
    private String text;

    @Column(
            name = "emotion"
    )
    private Integer emotion;

    @Column(
            name = "owner",
            columnDefinition = "Text"
    )
    private String owner;

    @Column(
            name = "image",
            columnDefinition = "Text"
    )
    private String image;


    public Note(String headline, String text, Integer emotion, String image) {
        this.date = LocalDate.now();
        this.headline = headline;
        this.text = text;
        this.emotion = emotion;
        this.image = image;
    }

    public Note(String headline, String text, Integer emotion, LocalDate date, String image) {
        this.date = LocalDate.now();
        this.headline = headline;
        this.text = text;
        this.emotion = emotion;
        this.date = date;
        this.image = image;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Note) {
            Note other = (Note) o;
            if (this.date.isBefore(other.date)) {
                return 1;
            }
            if (this.date.isAfter(other.date)) {
                return -1;
            }
            return 0;
        }
        return 0;
    }

    public Note() {
        this.date = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getEmotion() {
        return emotion;
    }

    public void setEmotion(Integer emotion) {
        this.emotion = emotion;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}