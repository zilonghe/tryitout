package cn.johnnyho.tryitout.contact.service.impl;

import cn.johnnyho.tryitout.contact.dao.ContactDao;
import cn.johnnyho.tryitout.contact.model.Contact;
import cn.johnnyho.tryitout.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author hezilong
 */
@Component
public class ContactServiceImpl implements ContactService
{
    private final ContactDao contactDao;

    private final RedisTemplate<String, Contact> redisTemplate;

    @Autowired
    public ContactServiceImpl(ContactDao contactDao, RedisTemplate redisTemplate)
    {
        this.contactDao = contactDao;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public List<Contact> getAllContacts()
    {
        return contactDao.findAll();
    }

    @Override
    public Contact getContactById(Long id) {
        String key = "Contact_" + id;
        ValueOperations<String, Contact> valueOperations = redisTemplate.opsForValue();

        if (redisTemplate.hasKey(key)) {
            return valueOperations.get(key);
        }
        Contact contactById = contactDao.findContactById(id);

        valueOperations.set(key, contactById, 10, TimeUnit.SECONDS);
        return contactById;
    }

    @Override
    public void insertContact(Contact contact)
    {
        contactDao.save(contact);
    }
}
