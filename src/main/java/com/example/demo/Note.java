package com.example.demo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.UUID;

public class Note {

    private String id;
    private LocalDate date;
    private String headline;
    private String text;
    private int emotion;
    //private List imageList;



    public Note(){
    }

    public Note(String headline, String text, int emotion) {
        this.id = UUID.randomUUID().toString();
        this.date = LocalDate.now(ZoneId.of("Europe/Berlin"));
        this.headline = headline;
        this.text = text;
        this.emotion = emotion;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getEmotion() {
        return emotion;
    }

    public void setEmotion(int emotion) {
        this.emotion = emotion;
    }
}
