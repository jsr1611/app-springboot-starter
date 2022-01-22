package uz.digitalone.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.digitalone.demo.model.Person;
import uz.digitalone.demo.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
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

    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public Person save(@RequestBody Person person){
        Person savedPerson = personRepo.save(person);
        return savedPerson;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public List<Person> findAll(){
        return personRepo.findAll();
    }

    @RequestMapping(value = "/persons/{id}", method = RequestMethod.GET)
    public Person findById(@PathVariable Long id){
        Optional<Person> optionalPerson = personRepo.findById(id);
        return optionalPerson.orElse(null);
    }

    @RequestMapping(value = "/persons/{id}", method = RequestMethod.PUT)
    public Person edit(@PathVariable Long id, @RequestBody Person person){
        Optional<Person> optionalPerson = personRepo.findById(id);
        if(optionalPerson.isPresent()){
            Person personToBeUpdated = optionalPerson.get();
            personToBeUpdated.setFirstname(person.getFirstname());
            personToBeUpdated.setLastname(person.getLastname());
            personToBeUpdated.setEmail(person.getEmail());
            return personRepo.save(personToBeUpdated);
        }
        return null;
    }

    @RequestMapping(value = "persons/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable Long id){
        if(personRepo.existsById(id)){
            personRepo.deleteById(id);
            return "Person with id {"+id+"} was successfully deleted";
        }
        return "Person with id {"+id+"} was not found";

    }

}
