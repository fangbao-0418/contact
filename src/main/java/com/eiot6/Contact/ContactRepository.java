package com.eiot6.Contact;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;

public interface ContactRepository extends CrudRepository<Contact, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Contact SET name = :name WHERE id = :id")
    void updateName(@Param("id") Integer id, @Param("name") String name);

    @Query("select count(*) from Contact c where c.ip = :ip")
    int getIpCount(@Param("ip") String ip);
}