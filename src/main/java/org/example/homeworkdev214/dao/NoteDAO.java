package org.example.homeworkdev214.dao;

import lombok.Data;
import org.example.homeworkdev214.model.Note;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Data
public class NoteDAO {
    private Map<Long, Note> notes = new HashMap<>();

    public List<Note> listAll() {
        return notes.values().stream().toList();
    }

    public Note add(Note note) {
        long id = new Random().nextLong(1000000000000000000L);
        while (getById(id).isPresent()) {
            id = new Random().nextLong(1000000000000000000L);
        }
        note.setId(id);
        notes.put(id, note);
        return note;
    }

    public void deleteById(long id) {
        getById(id).orElseThrow(IllegalArgumentException::new);
        notes.remove(id);
    }

    public void update(Note note) {
        getById(note.getId()).orElseThrow(IllegalArgumentException::new);
        notes.put(note.getId(), note);
    }

    public Optional<Note> getById(long id) {
        return Optional.ofNullable(notes.get(id));
    }
}
