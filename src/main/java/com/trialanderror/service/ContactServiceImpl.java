package com.trialanderror.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trialanderror.dao.ContactDAO;
import com.trialanderror.model.Contact;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDAO contactDAO;

    @Override
    @Transactional
    public void addContact(Contact contact) {
        contactDAO.addContact(contact);
    }

    @Override
    @Transactional
    public List<Contact> getAllContacts() {
        return contactDAO.getAllContacts();
    }

    @Override
    @Transactional
    public List<Contact> getContactsByQuery(String contactSearch){
        return contactDAO.getContactsByQuery(contactSearch);
    }

    @Override
    @Transactional
    public void deleteContact(Integer contactId) {
        contactDAO.deleteContact(contactId);
    }

    public Contact getContact(int empid) {
        return contactDAO.getContact(empid);
    }

    public Contact updateContact(Contact contact) {
        return contactDAO.updateContact(contact);
    }

    public void setContactDAO(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }
}