package com.moz.calendar.controller;


import com.moz.calendar.model.Note;
import com.moz.calendar.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private NoteService noteService;


//    @GetMapping("/notes")
//    public List<Note> getAllNotes() {
//        return noteService.getAllNotes();
//    }


}
