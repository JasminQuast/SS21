package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DiaryController {

    private final DiaryService diaryService;

    @Autowired
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }


    @GetMapping(path = "/notes")
        public String getNotes(Model model){

        var noteList = diaryService.getNotes();
        model.addAttribute("note", noteList
        );
            return "notes";
        }


    @GetMapping("/createNote")
    public String noteSubmit(Model model) {
        model.addAttribute("note", new Note());
        return "notecreation";
    }

    @PostMapping("/createNote")
    public String noteSubmit(@ModelAttribute Note note, Model model) {
        diaryService.createNote(note);
        model.addAttribute("note",note);
        return "noteresult";
    }
}
