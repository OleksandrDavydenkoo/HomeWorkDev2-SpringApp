package org.example.homeworkdev214.controller;

import org.example.homeworkdev214.model.Note;
import org.example.homeworkdev214.model.dto.*;
import org.example.homeworkdev214.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public CreateNoteResponse create(@RequestBody CreateNoteRequest request) {
        Note note = new Note();
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        Note createdNote = noteService.add(note);
        return createdNote != null ? CreateNoteResponse.success(createdNote.getId()) :
                CreateNoteResponse.failed(CreateNoteResponse.Error.invalidTitle); // Можна додати детальну валідацію
    }

    @GetMapping
    public List<Note> getNotes() {
        return noteService.listAll();
    }

    @PatchMapping("/{id}")
    public UpdateNoteResponse update(@PathVariable long id, @RequestBody UpdateNoteRequest request) {
        Note note = noteService.getById(id);
        if (note == null) {
            return UpdateNoteResponse.failed(UpdateNoteResponse.Error.invalidNoteId);
        }

        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        noteService.update(note);

        return UpdateNoteResponse.success(note);
    }

    @DeleteMapping("/{id}")
    public DeleteNoteResponse delete(@PathVariable long id) {
        Note note = noteService.getById(id);
        if (note == null) {
            return DeleteNoteResponse.failed(DeleteNoteResponse.Error.invalidNoteId);
        }
        noteService.deleteById(id);
        return DeleteNoteResponse.success();
    }
}