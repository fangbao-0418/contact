package com.eiot6.Contract;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;

public interface ContractRepository extends CrudRepository<Contract, Integer> {
    // @Transactional
    // @Modifying
    // @Query("UPDATE User u SET u.name = :name WHERE u.id = :id")
    // void updateName(@Param("id") Integer id, @Param("name") String name);

    // @Query("select u from User u where u.id = :id")
    // Contract findByUid(@Param("id") Integer id);
}