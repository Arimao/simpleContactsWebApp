package com.trialanderror.dao;

import java.util.List;
import com.trialanderror.model.Contact;

public interface ContactDAO {

    void addContact(Contact contact);

    List<Contact> getAllContacts();

    List<Contact> getContactsByQuery(String contactSearch);

    void deleteContact(Integer contactId);

    Contact updateContact(Contact contact);

    Contact getContact(int contactid);
}