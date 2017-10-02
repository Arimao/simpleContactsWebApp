package com.trialanderror.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.trialanderror.model.Contact;
import com.trialanderror.service.ContactService;


@Controller
public class ContactController {

    private static final Logger logger = Logger.getLogger(ContactController.class);

    public ContactController() {
        System.out.println("ContactController()");
    }

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/")
    public ModelAndView listContact(ModelAndView model) throws IOException {
        List<Contact> listContact = contactService.getAllContacts();
        Contact contact = new Contact();
        model.addObject("listContact", listContact);
        model.addObject("contact", contact);
        model.setViewName("home");
        return model;
    }

    @RequestMapping(value = "/searchContact", method = RequestMethod.POST)
    public ModelAndView searchContact(@ModelAttribute Contact contact) {
        ModelAndView model = new ModelAndView("home");
        String contactSearch = contact.getSearchString();
        List<Contact> searchContact = contactService.getContactsByQuery(contactSearch);
        model.addObject("searchContact", searchContact);
        return model;
    }

    @RequestMapping(value = "/newContact", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Contact contact = new Contact();
        model.addObject("contact", contact);
        model.setViewName("ContactForm");
        return model;
    }

    @RequestMapping(value = "/saveContact", method = RequestMethod.POST)
    public ModelAndView saveContact(@ModelAttribute Contact contact) {
        ModelAndView model = new ModelAndView("ContactForm");
        if (contact.getName().matches(".*\\d+.*")) {
            model.addObject("error", "Name cannot contain numbers.");
        }
        else if (contact.getName().isEmpty()) {
            model.addObject("error", "Name cannot be empty.");
        }
        else if (contact.getEmail().matches(".*@.*") == false) {
            model.addObject("error", "E-mail must contain @.");
        }
        else if (contact.getTelephone().matches(".*[a-zA-Z].*")) {
            model.addObject("error", "Telephone cannot contain letters.");
        }
        else if (contact.getTelephone().isEmpty()) {
            model.addObject("error", "Telephone cannot be empty.");
        }
        else if (contact.getId() == 0) {
            contactService.addContact(contact);
            model.setViewName("redirect:/");
        }
        else {
            contactService.updateContact(contact);
            model.setViewName("redirect:/");
        }
        return model;
    }

    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int contactId = Integer.parseInt(request.getParameter("id"));
        contactService.deleteContact(contactId);
        return new ModelAndView("redirect:/");
    }


    @RequestMapping(value = "/editContact", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int contactId = Integer.parseInt(request.getParameter("id"));
        Contact contact = contactService.getContact(contactId);
        ModelAndView model = new ModelAndView("ContactForm");
        model.addObject("contact", contact);
        return model;
    }
}