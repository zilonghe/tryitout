package cn.johnnyho.tryitout.contact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author hezilong
 */
@SpringBootApplication
@MapperScan("cn.johnnyho.tryitout.contact.dao")
public class TryitoutApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(TryitoutApplication.class, args);
    }
}
