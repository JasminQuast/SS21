package com.example.demo;

import java.util.List;


public interface DiaryService {

    List<Note> getNotes();
    void createNote();
    void updateNote();
    void deleteNote();

}
