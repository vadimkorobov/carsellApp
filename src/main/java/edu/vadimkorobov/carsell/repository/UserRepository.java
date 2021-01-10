package edu.vadimkorobov.carsell.repository;

import edu.vadimkorobov.carsell.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select a from User a where a.login = :login")
    User findByLogin(@Param("login") String login);


    @Query("delete from User a where a.id= :id")
    void delete(@Param("id") long id);


}
