package com.example.demo;

import config.Endpoints;
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

    @GetMapping(path = Endpoints.Site.HOME)
    public String homePage(Model model){

        //model.addAttribute("home", diaryService.);
        return "frontend/home";
    }

    @GetMapping(path = Endpoints.Site.OVERVIEW)
    public String overviewPage(Model model){

        //model.addAttribute("home", diaryService.);
        return "frontend/overview";
    }

    @GetMapping(path = Endpoints.Site.SETTINGS)
    public String settingPage(Model model){

        //model.addAttribute("home", diaryService.);
        return "frontend/settings";
    }

    @GetMapping(path = "/notes")
        public String getNotes(Model model){

        var noteList = diaryService.getNotes();
        model.addAttribute("note", noteList);
            return "/resources/templates/frontend/notes.html";
        }

    @GetMapping("/createNote")
    public String noteSubmit(Model model) {
        model.addAttribute("note", new Note());
        return "/resources/templates/frontend/notecreation.html";
    }

    @PostMapping("/createNote")
    public String noteSubmit(@ModelAttribute Note note, Model model) {
        diaryService.createNote(note);
        model.addAttribute("note",note);
        return "/resources/templates/frontend/noteresult.html";
    }
}
