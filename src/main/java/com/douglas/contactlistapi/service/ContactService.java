package com.douglas.contactlistapi.service;

import com.douglas.contactlistapi.entity.Contact;
import com.douglas.contactlistapi.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public Iterable<Contact> findAll() {
        return  contactRepository.findAll();
    }

    public Contact findById(Integer id) {
        return contactRepository
                .findById(id)
                .orElse(null);
    }

    public Contact create(Contact contact) {
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    public Contact update(Integer id, Contact form) {

        Contact contactFromDb = findById(id);

        contactFromDb.setName(form.getName());
        contactFromDb.setEmail(form.getEmail());

        return contactRepository.save(contactFromDb);
    }

    public void delete(Integer id) {

        Contact contactFromDb = findById(id);

        contactRepository.delete(contactFromDb);
    }
}
