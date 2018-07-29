package cn.johnnyho.tryitout.contact.service;

import cn.johnnyho.tryitout.contact.model.Contact;

import java.util.List;

/**
 * @author hezilong
 */
public interface ContactService
{
    /**
     * 获取所有账号信息
     * @return 账号信息列表
     */
    List<Contact> getAllContacts();

    /**
     * 根据id获取账号
     * @param id id
     * @return 账号信息
     */
    Contact getContactById(Long id);

    /**
     * 插入新的账号
     * @param contact 新增账号
     */
    void insertContact(Contact contact);
}
