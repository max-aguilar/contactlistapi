package com.douglas.contactlistapi.repository;

import com.douglas.contactlistapi.entity.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Integer> {



}
