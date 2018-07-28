package cn.johnnyho.tryitout.contact.service.impl;

import cn.johnnyho.tryitout.contact.dao.ContactDao;
import cn.johnnyho.tryitout.contact.model.Contact;
import cn.johnnyho.tryitout.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContactServiceImpl implements ContactService
{
    private final ContactDao contactDao;

    private final RedisTemplate redisTemplate;

    @Autowired
    public ContactServiceImpl(ContactDao contactDao, RedisTemplate redisTemplate)
    {
        this.contactDao = contactDao;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public List<Contact> getAllContacts()
    {
        ValueOperations<String, Contact> valueOperations = redisTemplate.opsForValue();

        return contactDao.findAll();
    }

    @Override
    public void insertContact(Contact contact)
    {
        contactDao.save(contact);
    }
}
