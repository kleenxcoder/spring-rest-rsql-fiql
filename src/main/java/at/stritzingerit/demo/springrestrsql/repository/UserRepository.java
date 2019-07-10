package at.stritzingerit.demo.springrestrsql.repository;

import at.stritzingerit.demo.springrestrsql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    @Query("SELECT u FROM User u WHERE u.active = 1")
    List<User> findActiveUsers();

    @Query("SELECT u FROM User u WHERE u.id = ?1")
    User findActiveUserById(Integer id);

    @Query(value = "SELECT u FROM User u WHERE u.firstName = :firstName")
    User findActiveUserByFirstName(@Param("firstName") String firstName);

    @Query(value = "SELECT * FROM User WHERE LAST_NAME = :firstName", nativeQuery = true)
    User findActiveUserByLastName(@Param("firstName") String firstName);

}
