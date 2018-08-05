package cn.johnnyho.tryitout.contact.service.impl;

import cn.johnnyho.tryitout.contact.dao.ContactDao;
import cn.johnnyho.tryitout.contact.model.Contact;
import cn.johnnyho.tryitout.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author hezilong
 */
@Service
public class ContactServiceImpl implements ContactService
{
    private final ContactDao contactDao;

    private final RedisTemplate<String, Contact> redisTemplate;

    @Autowired
    public ContactServiceImpl(ContactDao contactDao, RedisTemplate<String, Contact> redisTemplate)
    {
        this.contactDao = contactDao;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public List<Contact> getAllContacts()
    {
        return contactDao.findAll();
    }

    @Cacheable(value="contactInfo", key="'id_'+#id", unless="#result == null")
    @Override
    public Contact getContactById(Long id) {
        return getContact(id);
    }

    private Contact getContact(Long id) {
        System.out.println("cache not hit, query db");
        return contactDao.findContactById(id);
    }

    //    @CachePut(value="contactInfo", key="'id_'+#contact.getId()")
    @Override
    public void insertContact(Contact contact)
    {
        contactDao.save(contact);
    }
}
