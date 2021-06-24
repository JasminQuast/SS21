package com.example.demo.web;



import com.example.demo.DiaryService;
import com.example.demo.Note;
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


        @GetMapping(path = "/todaysNote")
        public Note note(@AuthenticationPrincipal OidcUser user) {
                var todaysNote = diaryService.getTodaysNote(user.getEmail());
                return todaysNote;
        }

        @PostMapping(path = "/todaysNote")
        public Note createNewNote(@AuthenticationPrincipal OidcUser user, @RequestBody Note note) {
                note.setOwner(user.getEmail());
                return diaryService.createNote(note);
        }

        @DeleteMapping("/deleteNote/{id}")
        public ResponseEntity<Long> deleteNote(@PathVariable long id) {

                diaryService.deleteNote(id);
//                var isRemoved = diaryService.deleteNote(id);
//                if (!isRemoved) {
//                        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//                }
                return new ResponseEntity<>(id, HttpStatus.OK);
        }

        @PutMapping("/updateNote/{id}")
        public ResponseEntity<Long> updateNote(@RequestBody Note updatedNote, @PathVariable long id){

               diaryService.updateNote(id, updatedNote);
//                var isUpdated = diaryService.updateNote(id, updatedNote);
//                if(!isUpdated) {
//                        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//                }
                return new ResponseEntity<>(id, HttpStatus.OK);
        }
}



