package uz.digitalone.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.digitalone.demo.model.Person;
import uz.digitalone.demo.repository.PersonRepository;

import java.util.List;

@RestController
public class PersonController {
/*
    public static List<Person> personList = new ArrayList<>(Arrays.asList(
            new Person(1L, "Ali", "Ali", "ali@gmail.com"),
            new Person(2L, "Vali", "Vali","vali@gmail.com"),
            new Person(3L, "Holid", "Holid", "holid@gmail.com"),
            new Person(4L, "Malik", "Malik", "malik@gmail.com"),
            new Person(5L, "Solih", "Solih", "solih@gmail.com")
    ));
*/
    @Autowired
    private PersonRepository personRepository;



    private final PersonRepository personRepo;
    public PersonController(PersonRepository personRepository){
        this.personRepo = personRepository;
    }

    @RequestMapping(value = "/api/persons", method = RequestMethod.POST)
    public Person save(@RequestBody Person person){
        Person savedPerson = personRepo.save(person);
        return savedPerson;
    }

    @RequestMapping(value = "/api/persons", method = RequestMethod.GET)
    public List<Person> findAll(){
        return null;
    }
}
