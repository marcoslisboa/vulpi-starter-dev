package com.vulpi.starterdev.service;

import com.vulpi.starterdev.domain.contact.Contact;
import com.vulpi.starterdev.exception.EntityNotFoundException;
import com.vulpi.starterdev.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository repository;


    public Page<Contact> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Contact findOne(Long id) {
        Optional<Contact> contact = repository.findById(id);
        if (!contact.isPresent()) {
            throw new EntityNotFoundException(id);
        }

        return contact.get();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Contact save(Contact contact) {
        return repository.save(contact);
    }

    public Contact update(Long id, Contact contact) {
        contact.setId(id);
        return repository.save(contact);
    }

    public List<Contact> findAll() {
        return repository.findAll();
    }
}
