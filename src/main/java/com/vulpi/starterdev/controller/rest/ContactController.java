package com.vulpi.starterdev.controller.rest;

import com.vulpi.starterdev.domain.contact.Contact;
import com.vulpi.starterdev.service.ContactService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;


@Log
@RestController
@RequestMapping("/rest/contacts")
public class ContactController {

    @Autowired
    private ContactService service;

    @GetMapping
    public ResponseEntity<Page<Contact>> findAll(Pageable pageable) {
        log.info("Fetching All Contacts");

        Page<Contact> page = service.findAll(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findOne(@PathVariable("id") Long id) {
        log.info("Fetching Contact with id: " + id);
        Contact app = service.findOne(id);
        return new ResponseEntity<>(app, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Contact contact, UriComponentsBuilder uri) {
        log.info("Creating Contact");
        Contact entity = service.save(contact);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uri.path("/api/contacts/{id}").buildAndExpand(contact.getId()).toUri());
        return new ResponseEntity<>(entity, headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Contact contact) {
        log.info("Updating Contact with id " + id);

        Contact entity = service.update(id, contact);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        log.info("Fetching & Deleting Contact with id " + id);

        service.delete(id);
        return new ResponseEntity<Contact>(HttpStatus.OK);
    }

}
