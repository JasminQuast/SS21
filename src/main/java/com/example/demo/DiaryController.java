package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DiaryController {

    @PostMapping("/createNote")
    public String noteSubmit(@ModelAttribute Note note, Model model) {
        //diaryService.save(note);
        model.addAttribute("note", note);
        return "noteresult";
    }
}
