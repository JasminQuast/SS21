package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
public class DiaryRestController {

        private final DiaryService diaryService;

        @Autowired
        public DiaryRestController(DiaryService diaryService) {
                this.diaryService = diaryService;
        }

        @GetMapping("/")
        public List<Note> test(){
                return List.of(
                        new Note(
                                "I'm a headline",
                                "I'm a text ...",
                                3,
                                LocalDate.of(2000, Month.APRIL,4)
                        )
                );
        }

        @GetMapping(path = "/note")
        public ResponseEntity<List<Note>> getAllNotes (){
                var noteList = diaryService.getNotes();
           return ResponseEntity.ok(noteList);
        }

        @PostMapping(path = "/note")
        public void createNewNote(@RequestBody Note note){
                diaryService.createNote(note);
        }

}



