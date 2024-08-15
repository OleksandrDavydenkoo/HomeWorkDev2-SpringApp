package org.example.homeworkdev214.model.dto;


import lombok.Builder;
import lombok.Data;
import org.example.homeworkdev214.model.Note;

@Data
@Builder
public class UpdateNoteResponse {
    private Error error;
    private Note updatedNote;

    public enum Error {
        ok,
        invalidNoteId,
        invalidTitleLength,
        invalidContentLength
    }

    public static UpdateNoteResponse success(Note updateNote) {
        return builder().error(Error.ok).updatedNote(updateNote).build();
    }

    public static UpdateNoteResponse failed(Error error) {
        return builder().error(error).updatedNote(null).build();
    }
}
