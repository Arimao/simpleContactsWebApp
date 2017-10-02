package com.trialanderror.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.trialanderror.model.Contact;

@Repository
public class ContactDAOImpl implements ContactDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addContact(Contact contact) {
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
    }

    @SuppressWarnings("unchecked")
    public List<Contact> getAllContacts() {
        return sessionFactory.getCurrentSession().createQuery("from Contact").list();
    }

    public List<Contact> getContactsByQuery(String contactSearch) {
        return sessionFactory.getCurrentSession().createQuery("from Contact where (name like '%" + contactSearch + "%' OR address like '%"+ contactSearch +"%' OR telephone like '%"+ contactSearch +"%' OR email like '%"+ contactSearch +"%')").list();
    }

    @Override
    public void deleteContact(Integer contactId) {
        Contact contact = (Contact) sessionFactory.getCurrentSession().load(Contact.class, contactId);
        if (null != contact) {
            this.sessionFactory.getCurrentSession().delete(contact);
        }
    }

    public Contact getContact(int empid) {
        return (Contact) sessionFactory.getCurrentSession().get(Contact.class, empid);
    }

    @Override
    public Contact updateContact(Contact contact) {
        sessionFactory.getCurrentSession().update(contact);
        return contact;
    }

}