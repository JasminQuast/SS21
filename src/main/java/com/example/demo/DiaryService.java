package com.example.demo;

import java.util.List;

public interface DiaryService {

    List<Note> getNotes();
    void createNote(Note note);
    void updateNote();
    void deleteNote();

}
