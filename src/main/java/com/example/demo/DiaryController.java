package com.example.demo;

import com.example.demo.config.Endpoints;
import com.example.demo.config.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DiaryController {

    private final DiaryService diaryService;

    @Autowired
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @GetMapping(path = Endpoints.Site.DIARYST)
    public ModelAndView mainPage(Model model) {
        return new ModelAndView(ViewNames.DIARYST);
    }

    @GetMapping(path = Endpoints.Site.SLASH)
    public ModelAndView mainPageSlash(Model model) {
        return new ModelAndView(ViewNames.DIARYST);
    }

    @GetMapping(path = Endpoints.Site.OVERVIEW)
    public ModelAndView overviewPage(@AuthenticationPrincipal OidcUser user, Model model) {
        var noteList = diaryService.getNotesUser(user.getEmail());
        model.addAttribute("note", noteList);
        return new ModelAndView(ViewNames.OVERVIEW);
    }

    @GetMapping(path = Endpoints.Site.TODAY)
    public ModelAndView todaysNote() {
        return new ModelAndView(ViewNames.TODAYSNOTE);
    }

}
