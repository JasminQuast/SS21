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
    public ModelAndView mainPage(Model model){

        return new ModelAndView(ViewNames.DIARYST);
    }

    @GetMapping(path = Endpoints.Site.SLASH)
    public ModelAndView mainPageSlash(Model model){

        return new ModelAndView(ViewNames.DIARYST);
    }

    @GetMapping(path = Endpoints.Site.SETTINGS)
    public ModelAndView settingPage(Model model) {

        return new ModelAndView(ViewNames.SETTINGS);
    }

    @GetMapping(path = Endpoints.Site.OVERVIEW)
    public ModelAndView overviewPage(@AuthenticationPrincipal OidcUser user, Model model){
        var noteList = diaryService.getNotesUser(user.getEmail());
        model.addAttribute("note", noteList);
        return new ModelAndView(ViewNames.OVERVIEW);
    }
    @GetMapping(path = Endpoints.Site.TODAY)
    public ModelAndView noteSubmit(@AuthenticationPrincipal OidcUser user, Model model){

        Note todaysNote = diaryService.getTodaysNote(user.getEmail());
        model.addAttribute("note", new Note());

        //rausgenommen, um zu testen ob heutige Note in der Vue Komponente angezeigt wird
//        if (todaysNote != null) {
//            model.addAttribute("note", todaysNote);
//            return new ModelAndView(ViewNames.TODAY2);
//        }
        return new ModelAndView(ViewNames.NOTECREATION);
    }

    @PostMapping(path = Endpoints.Site.TODAY)
    public ModelAndView noteSubmit(@AuthenticationPrincipal OidcUser user,@ModelAttribute Note note, Model model) {
        note.setOwner(user.getEmail());
        diaryService.createNote(note);
        model.addAttribute("note",note);
        return new ModelAndView(ViewNames.TODAY2);
    }

//    @GetMapping(path = Endpoints.Site.NOTERESULT)
//    public ModelAndView noteResult(Model model){
//        return new ModelAndView(ViewNames.TODAY);
//    }
//
//    @GetMapping(path = "/editNote")
//    public ModelAndView editNote (@RequestParam long id, Model model){
//        Note noteById = diaryService.getNoteById(id);
//        if(noteById != null){
//            model.addAttribute("note", noteById);
//            return new ModelAndView("editNote");
//        }
        //error.Html hinzufügen und zurückgeben, falls ID in URL händisch abgeändert wurde
//        return null;
//    }


}
