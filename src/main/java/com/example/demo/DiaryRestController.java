package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class DiaryRestController {

        private final DiaryService diaryServive;

        @Autowired
        public DiaryRestController(DiaryService diaryServive) {
                this.diaryServive = diaryServive;
        }

        @GetMapping(path = "/note")
        public ResponseEntity<List<Note>> getAllNotes (){
                var noteList = diaryServive.getNotes();
           return ResponseEntity.ok(noteList);
        }

        @PostMapping(path = "/note")
        public void createNewNote(@RequestBody Note note){
                diaryServive.createNote(note);
        }
}



