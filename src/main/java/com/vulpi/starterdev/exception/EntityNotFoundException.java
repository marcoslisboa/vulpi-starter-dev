package com.vulpi.starterdev.exception;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends ServiceException {

    public EntityNotFoundException(Long id) {
        super("Not found: " + id);
    }
}
