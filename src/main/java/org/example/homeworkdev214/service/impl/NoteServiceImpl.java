package org.example.homeworkdev214.service.impl;

import org.example.homeworkdev214.dao.NoteDAO;
import org.example.homeworkdev214.model.Note;
import org.example.homeworkdev214.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteDAO noteDAO;

    @Autowired
    public NoteServiceImpl(NoteDAO noteDAO) {
        this.noteDAO = noteDAO;
    }

    @Override
    public List<Note> listAll() {
        return noteDAO.listAll();
    }

    @Override
    public Note add(Note note) {
        return noteDAO.add(note);
    }

    @Override
    public void deleteById(long id) {
        noteDAO.getById(id).orElseThrow(() -> new IllegalArgumentException("Note not found for id: " + id));
        noteDAO.deleteById(id);
    }

    @Override
    public void update(Note note) {
        noteDAO.getById(note.getId()).orElseThrow(() -> new IllegalArgumentException("Note not found for id: " + note.getId()));
        noteDAO.update(note);
    }

    @Override
    public Note getById(long id) {
        return noteDAO.getById(id).orElseThrow(() -> new IllegalArgumentException("Note not found for id: " + id));
    }
}
