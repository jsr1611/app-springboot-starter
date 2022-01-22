package uz.digitalone.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.digitalone.demo.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
