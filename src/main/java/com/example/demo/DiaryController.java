package com.example.demo;

import config.Endpoints;
import config.ViewNames;
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

    @GetMapping(path = Endpoints.Site.OVERVIEW)
    public ModelAndView overviewPage(@AuthenticationPrincipal OidcUser user,  Model model){
        var noteList = diaryService.getNotesUser(user);
        model.addAttribute("note", noteList);
        return new ModelAndView(ViewNames.OVERVIEW);
    }

    @GetMapping(path = Endpoints.Site.SETTINGS)
    public ModelAndView settingPage(Model model) {

        //model.addAttribute("home", diaryService.);
        return new ModelAndView(ViewNames.SETTINGS);
    }


//    @GetMapping(path = Endpoints.Site.HOME)
//    public ModelAndView noteSubmit(Model model, Note note) throws SQLException {
        // wenn vorhanden Datum von heute vorhanden
//
//        String dateSQL = "SELECT date FROM note";
//        List<Date> dates = new LinkedList<>();
//
//        PreparedStatement ps = useConnection().prepareStatement(dateSQL);
//            ResultSet rs = ps.executeQuery();
//                while (rs.next()) {
//                     Date date = rs.getDate("date");
//                    dates.add(date);
//                }
//
//                if(dates.contains(LocalDate.now())){
//                    return new ModelAndView(ViewNames.HOME2);
//                }
//                else{
//                    model.addAttribute("note", new Note());
//                    return new ModelAndView(ViewNames.NOTECREATION);
//                }


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
        //model.addAttribute("note", new Note());
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
