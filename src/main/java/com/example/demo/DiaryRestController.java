package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class DiaryRestController {

        private final DiaryService diaryService;


        public DiaryRestController(DiaryService diaryService) {
                this.diaryService = diaryService;
        }

        @GetMapping("/getNote")
        public ResponseEntity<List<Note>> getAllNotes (){
                var list = diaryService.getNotes();
                return ResponseEntity.ok(list);
        }

        @PostMapping("/note")
                public ResponseEntity<Void> note (){
                        diaryService.createNote();
                        return ResponseEntity.ok().build();
                }


        }



