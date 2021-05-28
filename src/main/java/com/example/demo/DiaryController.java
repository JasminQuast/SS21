package com.example.demo;

import config.Endpoints;
import config.ViewNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class DiaryController {

    private final DiaryService diaryService;
//    private Connection connection;
//    private static final Logger L = LoggerFactory.getLogger(DiaryController.class);
//
//    public void setConnection(Connection connection) {
//        this.connection = connection;
//    }
//
//    protected Connection useConnection() {
//        /*if (connection == null) {
//            throw new DataException("");
//        }*/
//        return this.connection;
//    }

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
    public ModelAndView noteSubmit(Model model, Note note) throws SQLException {
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

            /*} catch (SQLException e) {
                L.error("Result Error", e);
                throw new DataException(e);
            }
        } catch (SQLException e) {
            L.error("Statement Error", e);
            throw new DataException(e);
        }*/

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
