package cn.johnnyho.tryitout.contact.service;

import cn.johnnyho.tryitout.contact.model.Contact;

import java.util.List;

public interface ContactService
{
    /**
     * 获取所有账号信息
     * @return 账号信息列表
     */
    List<Contact> getAllContacts();

    /**
     * 插入新的账号
     * @param contact 新增账号
     */
    void insertContact(Contact contact);
}
