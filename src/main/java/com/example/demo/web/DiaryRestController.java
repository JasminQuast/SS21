package com.example.demo.web;


import com.example.demo.DiaryService;
import com.example.demo.Note;
import org.springframework.beans.factory.annotation.Autowired;
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


        @GetMapping(path = "/todaysNote")
        public Note note(@AuthenticationPrincipal OidcUser user){
                var todaysNote = diaryService.getTodaysNote(user);
                return todaysNote;
        }

//        @PostMapping(path = "/todaysNote" )
//        public Note NewNote(@RequestBody Note note){
//                System.out.println("Noteeeee: " + note);
//                return diaryService.createNote(note);
//        }
        @PostMapping(path = "/todaysNote")
        public Note createNewNote(@AuthenticationPrincipal OidcUser user, @RequestBody Note note){
               note.setOwner(user.getEmail());
               return diaryService.createNote(note);
        }
}



