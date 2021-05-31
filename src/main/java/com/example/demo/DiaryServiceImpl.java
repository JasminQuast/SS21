package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryService {

    private final DiaryRepository diaryRepository;

    @Autowired
    public DiaryServiceImpl(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    @Override
    public List<Note> getNotes() {
        return diaryRepository.findAll();
    }

    @Override
    public void createNote(Note note) {
        diaryRepository.save(note);
    }

    @Override
    public void updateNote() {
    }

    @Override
    public void deleteNote() {
    }

    @Override
    public Note getNote(OidcUser user) {

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
}
