package cn.johnnyho.tryitout.contact.dao;

import cn.johnnyho.tryitout.contact.model.Contact;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hezilong
 */
public interface ContactDao
{
    /**
     * 查询所有账号信息
     * @return 所有账号信息
     */
    List<Contact> findAll();

    /**
     * 存储账号
     * @param contact 被存储的账号
     */
    void save(@Param("contact") Contact contact);

    /**
     * 根据id查询账号
     * @param id id
     * @return 目标账号
     */
    Contact findContactById(Long id);
}
