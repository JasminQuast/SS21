package com.example.demo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DiaryServiveImpl implements DiaryService {

    //List<String> noteList;

    @Override
    public List<Note> getNotes() {
     //   return null;
      return List.of(new Note(LocalDate.now(), "Erste Notiz", "BLABLA", 0 ));
    }

    @Override
    public void createNote() {
        Note note = new Note();
       // noteList.add(note);
    }

    @Override
    public void updateNote() {

    }

    @Override
    public void deleteNote() {

    }
}
