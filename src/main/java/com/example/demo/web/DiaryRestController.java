package com.example.demo.web;

import com.example.demo.DiaryService;
import com.example.demo.Note;
import config.Endpoints;
import config.ViewNames;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class DiaryRestController {

        private final DiaryService diaryService;

        public DiaryRestController(DiaryService noteService) {
                this.diaryService = noteService;
        }


        @GetMapping(path = Endpoints.Site.OVERVIEW)
        public ModelAndView overviewPage(@AuthenticationPrincipal OidcUser user, Model model){
                var noteList = diaryService.getNotesUser(user);
                model.addAttribute("note", noteList);
                return new ModelAndView(ViewNames.OVERVIEW);
        }
        @GetMapping(path = Endpoints.Site.TODAY)
        public ModelAndView noteSubmit(@AuthenticationPrincipal OidcUser user, Model model){

                Note todaysNote = diaryService.getTodaysNote(user);
                if (todaysNote != null) {
                        model.addAttribute("note", todaysNote);
                        return new ModelAndView(ViewNames.TODAY2);
                }
                model.addAttribute("note", new Note());
                return new ModelAndView(ViewNames.NOTECREATION);
        }

        @PostMapping(path = Endpoints.Site.TODAY)
        public ModelAndView noteSubmit(@AuthenticationPrincipal OidcUser user,@ModelAttribute Note note, Model model) {
                note.setOwner(user.getEmail());
                diaryService.createNote(note);
                model.addAttribute("note",note);
                return new ModelAndView(ViewNames.TODAY2);
        }

        @GetMapping(path = Endpoints.Site.NOTERESULT)
        public ModelAndView noteResult(Model model){
                return new ModelAndView(ViewNames.TODAY);
        }

        @GetMapping(path = "/editNote")
        public ModelAndView editNote (@RequestParam long id, Model model){
                Note noteById = diaryService.getNoteById(id);
                if(noteById != null){
                        model.addAttribute("note", noteById);
                        return new ModelAndView("editNote");
                }
                //error.Html hinzufügen und zurückgeben, falls ID in URL händisch abgeändert wurde
                return null;
        }

}



