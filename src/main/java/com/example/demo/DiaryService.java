package com.example.demo;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import java.util.List;

public interface DiaryService {

    List<Note> getNotes();
    void createNote(Note note);
    void updateNote();
    void deleteNote();
    Note getNote(OidcUser user);
}
