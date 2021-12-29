package com.github.thiagohmatos.foo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedEntryCharacter extends  RuntimeException{

    private static final long serialVersionUID = 1l;

    public UnsuportedEntryCharacter() {
    }

    public UnsuportedEntryCharacter(String message) {
        super(message);
    }
}
