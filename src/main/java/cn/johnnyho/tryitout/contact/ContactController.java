package cn.johnnyho.tryitout.contact;

import cn.johnnyho.tryitout.contact.dao.ContactDao;
import cn.johnnyho.tryitout.contact.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class ContactController
{
    @Autowired
    private ContactDao contactDao;

    @RequestMapping(method = RequestMethod.GET)
    public String home(Map<String, Object> model)
    {
        List<Contact> contactList = contactDao.findAll();
        model.put("contacts", contactList);
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(Contact contact)
    {
        contactDao.save(contact);
        return "redirect:/";
    }
}
