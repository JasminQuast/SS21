package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Note> getNotesUser(String userEmail) {
        var noteList = diaryRepository.findAll();
        List<Note> noteListUser = new LinkedList<>();
        for (Note note : noteList) {
            if (note.getOwner() != null) {
                if (note.getOwner().equals(userEmail)) {
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

    public boolean updateNote(long id, Note updatedNote ) {
        var idExists = diaryRepository.existsById(id);
        if(idExists) {
            diaryRepository.findById(id).map(note -> {
                note.setHeadline(updatedNote.getHeadline());
                note.setText(updatedNote.getText());
                note.setEmotion(updatedNote.getEmotion());
                note.setImage(updatedNote.getImage());
                diaryRepository.save(note);
                return true;
            });
        }
            return false;
    }

    public boolean deleteNote(long id) {

        var idExists = diaryRepository.existsById(id);
        if(idExists) {
            diaryRepository.deleteById(id);
            return true;
        } else{
            return false;
        }
    }

    public Note getTodaysNote(String userEmail) {

        var noteList = diaryRepository.findAll();
        for (Note note : noteList) {
            if (note.getOwner() != null) {
                if (note.getOwner().equals(userEmail)) {
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

