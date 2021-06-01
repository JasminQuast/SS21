package com.example.demo;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import java.util.List;
import java.util.Optional;

public interface DiaryService {

    List<Note> getNotesUser(OidcUser user);
    void createNote(Note note);
    void updateNote();
    void deleteNote();
    Note getTodaysNote(OidcUser user);
    Note getNoteById(long id);
}
