package com.example.demo;

import config.Endpoints;
import config.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DiaryController {

    private final DiaryService diaryService;

    @Autowired
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @GetMapping(path = Endpoints.Site.OVERVIEW)
    public ModelAndView overviewPage(Model model){

        var noteList = diaryService.getNotes();
        model.addAttribute("note", noteList);
        return new ModelAndView(ViewNames.OVERVIEW);
    }

    @GetMapping(path = Endpoints.Site.SETTINGS)
    public ModelAndView settingPage(Model model) {

        //model.addAttribute("home", diaryService.);
        return new ModelAndView(ViewNames.SETTINGS);
    }

    @GetMapping(path = Endpoints.Site.HOME)
    public ModelAndView noteSubmit(Model model) {
        // wenn vorhanden / nicht vorhanden
        model.addAttribute("note", new Note());
        return new ModelAndView(ViewNames.NOTECREATION);
    }

    @PostMapping(path = Endpoints.Site.HOME)
    public ModelAndView noteSubmit(@ModelAttribute Note note, Model model) {
        diaryService.createNote(note);
        model.addAttribute("note",note);
        return new ModelAndView(ViewNames.HOME2);
    }

    @GetMapping(path = Endpoints.Site.NOTERESULT)
    public ModelAndView noteResult(Model model){
        //model.addAttribute("note", new Note());
        return new ModelAndView(ViewNames.HOME);
    }
}
