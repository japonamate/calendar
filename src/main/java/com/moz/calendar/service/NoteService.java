package com.moz.calendar.service;

import com.moz.calendar.model.Note;

import java.util.List;

public interface NoteService {
    List<Note> getAllNotes();
    Note findById(Integer id);




}
