package cn.johnnyho.tryitout.contact;

import cn.johnnyho.tryitout.contact.model.Contact;
import cn.johnnyho.tryitout.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class ContactController
{
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService)
    {
        this.contactService = contactService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Map<String, Object> model)
    {
        List<Contact> contactList = contactService.getAllContacts();
        model.put("contacts", contactList);
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(Contact contact)
    {
        contactService.insertContact(contact);
        return "redirect:/";
    }

    @RequestMapping(value = "/api/contact/{id}", method = RequestMethod.GET)
    public Contact findOneContact(@PathVariable("id") Long id)
    {
        Contact contactById = contactService.getContactById(id);
        return contactById;
    }
}
