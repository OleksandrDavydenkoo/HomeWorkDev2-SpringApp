package org.example.homeworkdev214.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteNoteResponse {
    private Error error;

    public enum Error {
        ok,
        invalidNoteId
    }

    public static DeleteNoteResponse success() {
        return builder().error(Error.ok).build();
    }

    public static DeleteNoteResponse failed(Error error) {
        return builder().error(error).build();
    }
}
