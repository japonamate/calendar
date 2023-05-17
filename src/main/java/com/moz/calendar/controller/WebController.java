package com.moz.calendar.controller;


import com.moz.calendar.model.Note;
import com.moz.calendar.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("bloknote", noteService.getAllNotes());
        return "index";
    }


    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("bloknote", new Note());
        return "add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Note note, Model model) {
        model.addAttribute("bloknote", note);
        return "result";
    }

}
