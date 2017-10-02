package com.trialanderror.service;

import java.util.List;
import com.trialanderror.model.Contact;

public interface ContactService {

    void addContact(Contact contact);

    List<Contact> getAllContacts();

    List<Contact> getContactsByQuery(String contactSearch);

    void deleteContact(Integer contactId);

    Contact getContact(int contactid);

    Contact updateContact(Contact contact);
}