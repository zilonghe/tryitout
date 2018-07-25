package cn.johnnyho.tryitout.contact.dao;

import cn.johnnyho.tryitout.contact.model.Contact;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContactDao
{
    List<Contact> findAll();

    void save(@Param("contact") Contact contact);
}
