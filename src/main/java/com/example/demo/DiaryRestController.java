package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
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

        /*@GetMapping("/testTemplate")
        public String home(Model m) {
              Data d = new Data();
              m.setAttribute(d.myData);
              return "noteresult";
        }

        @PostMapping("/createNote")
        public String noteSubmit(@ModelAttribute Note note, Model model) {
                diaryService.save(note);
                model.addAttribute("note", note);
                return "noteresult";
        }*/
}



