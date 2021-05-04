package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
public class DiaryRestController {

        private final DiaryService diaryServive;

        @Autowired
        public DiaryRestController(DiaryService diaryServive) {
                this.diaryServive = diaryServive;
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

        @GetMapping(path = "/noteList")
        public ResponseEntity<List<Note>> getAllNotes (){
                var noteList = diaryServive.getNotes();
           return ResponseEntity.ok(noteList);
        }

        /*@PostMapping(path = "/note")
        public void createNewNote(@RequestBody Note note){
                diaryServive.createNote(note);
        }*/
}



