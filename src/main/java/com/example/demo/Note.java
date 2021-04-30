package com.example.demo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Note {

    private String id;
    private LocalDate date;
    private String headline;
    private String text;
    private int emotion;
    private List imageList;

    public Note(int id, Date date, String headline, String text, int emotion, List imageList) {
        this.id = UUID.randomUUID().toString();
        this.date = LocalDate.now(ZoneId.of("Europe/Berlin"));
        this.headline = headline;
        this.text = text;
        this.emotion = emotion;
        this.imageList = imageList;
    }

    public Note(){
    }

}
