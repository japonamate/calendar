package com.moz.calendar.repository;

import com.moz.calendar.model.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NoteRepository extends CrudRepository<Note, Integer> {
//    List<Note> findAllById();
    List<Note> findAllByOrderById();
//    Note findById(Integer id);
}
