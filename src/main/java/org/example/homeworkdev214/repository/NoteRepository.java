package org.example.homeworkdev214.repository;

import org.example.homeworkdev214.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
