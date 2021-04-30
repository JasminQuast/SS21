package com.example.demo;

import java.util.List;

public class DiaryServiveImpl implements DiaryService {

    List<Note> noteList;

    @Override
    public List<Note> getNotes() {
        return noteList;
    }

    @Override
    public void createNote() {
        Note note = new Note();
        noteList.add(note);
    }

    @Override
    public void updateNote() {

    }

    @Override
    public void deleteNote() {

    }
}
