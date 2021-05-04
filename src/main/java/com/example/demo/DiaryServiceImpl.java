package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public void updateNote() {}

    @Override
    public void deleteNote() {

    }
}
