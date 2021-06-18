package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@Service
public class DiaryService {

    @Autowired
    private DiaryRepository diaryRepository;

    public List<Note> findAll(String userEmail){
        var iterator = diaryRepository.findAll();
        var notes = new ArrayList<Note>();
        for (Note n : iterator) {
            if(n.getOwner() != null && n.getOwner().equals(userEmail)) notes.add(n);
        }
        return notes;
    }

//    public DiaryService(DiaryRepository diaryRepository) {
//        this.diaryRepository = diaryRepository;
//    }

    public List<Note> getNotesUser(OidcUser user) {
        var noteList = diaryRepository.findAll();
        List<Note> noteListUser = new LinkedList<>();
        for (Note note : noteList) {
            if (note.getOwner() != null) {
                if (note.getOwner().equals(user.getEmail())) {
                    if (!note.getDate().equals(LocalDate.now())) {
                        noteListUser.add(note);
                    }
                }
            }
        }
        noteListUser.sort(Note::compareTo);
        return noteListUser;
    }

    public Note createNote(Note note) {
        diaryRepository.save(note);
        return note;
    }

    public void updateNote() {
    }

    public void deleteNote() {
    }

    public Note getTodaysNote(OidcUser user) {

        var noteList = diaryRepository.findAll();
        for (Note note : noteList) {
            if (note.getOwner() != null) {
                if (note.getOwner().equals(user.getEmail())) {
                    if (note.getDate().equals(LocalDate.now())) {
                        return note;
                    }
                }
            }
        }
        return null;
    }


    public Note getNoteById(long id) {
        var noteOptional = diaryRepository.findById(id);
        Note noteById = noteOptional.get();
        return noteById;
        }


}

