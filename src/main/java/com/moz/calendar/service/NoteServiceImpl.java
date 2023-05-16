package com.moz.calendar.service;

import com.moz.calendar.model.Note;
import com.moz.calendar.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> getAllNotes(){
//        return noteRepository.findAllById();
        return noteRepository.findAllByOrderById();
    }

    @Override
    public Note findById(Integer id){
        Note note = noteRepository.findById(id).orElseThrow();
        return note;
    }


}
