package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.time.LocalDate;
import java.util.Arrays;

@Controller
public class DiaryController {

    private final DiaryService diaryService;

    @Autowired
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }


    @GetMapping(path = "/notes")
        public String getNotes(Model model){

        model.addAttribute("note", Arrays.asList(
                new Note("erste Notiz", "123", 1, LocalDate.now()),
                new Note("zweite Notiz", "abc", 2, LocalDate.now())
        ));
            return "notes";
        }


    @PostMapping("/createNote")
    public String noteSubmit(@ModelAttribute Note note, Model model) {
        //diaryService.createNote(note);
        model.addAttribute("note",note);
        return "noteresult";
    }
}
