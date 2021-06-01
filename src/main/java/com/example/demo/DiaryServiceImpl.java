package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


@Service
public class DiaryServiceImpl implements DiaryService {

    private final DiaryRepository diaryRepository;

    @Autowired
    public DiaryServiceImpl(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    @Override
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

    @Override
    public Note getNoteById(long id) {
        var noteOptional = diaryRepository.findById(id);
        Note noteById = noteOptional.get();
        return noteById;
        }

    }

