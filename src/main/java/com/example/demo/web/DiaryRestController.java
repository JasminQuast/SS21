package com.example.demo.web;

import com.example.demo.DiaryService;
import com.example.demo.Note;
import com.example.demo.config.Endpoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;

@RestController
public class DiaryRestController {

    private final DiaryService diaryService;

    @Autowired
    public DiaryRestController(DiaryService noteService) {
        this.diaryService = noteService;
    }

    @GetMapping(path = Endpoints.Site.TODAYSNOTE)
    public Note note(@AuthenticationPrincipal OidcUser user) {
        var todaysNote = diaryService.getTodaysNote(user.getEmail());
        return todaysNote;
    }

    @PostMapping(path = Endpoints.Site.TODAYSNOTE)
    public Note createNewNote(@AuthenticationPrincipal OidcUser user, @RequestBody Note note) {
        note.setOwner(user.getEmail());
        return diaryService.createNote(note);
    }

    @DeleteMapping( "/deleteNote/{id}")
    public ResponseEntity<Long> deleteNote(@PathVariable long id) {
        diaryService.deleteNote(id);
        //bei unten stehnder Variante gibt es Probleme mit der Vue Komponente, da diese nicht auf die Response wartet
//        var isRemoved = diaryService.deleteNote(id);
//        if (!isRemoved) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping("/updateNote/{id}")
    public ResponseEntity<Long> updateNote(@RequestBody Note updatedNote, @PathVariable long id) {
        diaryService.updateNote(id, updatedNote);
        //bei unten stehnder Variante gibt es Probleme mit der Vue Komponente, da diese nicht auf die Response wartet
//                var isUpdated = diaryService.updateNote(id, updatedNote);
//                if(!isUpdated) {
//                        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//                }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}



