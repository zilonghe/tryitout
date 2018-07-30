package cn.johnnyho.tryitout.contact;

import cn.johnnyho.tryitout.contact.model.Contact;
import cn.johnnyho.tryitout.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ContactController
{
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService)
    {
        this.contactService = contactService;
    }

    @RequestMapping(value="/api/contacts", method = RequestMethod.GET)
    public List<Contact> getAllContacts()
    {
        return contactService.getAllContacts();
    }

    @RequestMapping(value="/api/contact", method = RequestMethod.POST)
    public void addContact(@RequestBody Contact contact)
    {
        contactService.insertContact(contact);
    }

    @RequestMapping(value = "/api/contact/{id}", method = RequestMethod.GET)
    public Contact findOneContact(@PathVariable("id") Long id)
    {
        return contactService.getContactById(id);
    }
}
