package web.dao;

import org.springframework.stereotype.Component;
import web.Models.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static long PEOPLE_COUNT;
    private List<Person> people;
    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Georg", "Pavlov", "Pavlov@G"));
        people.add(new Person(++PEOPLE_COUNT, "MAISKA", "Mais", "No email"));
        people.add(new Person(++PEOPLE_COUNT, "Dolg", "DOLG", "Dolga@Nat"));
        people.add(new Person(++PEOPLE_COUNT, "Natalia", "Dolganova", "Natalia@Dolgi"));
    }

    public List<Person> index() {
        return people;
    }
    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setFirstName(updatedPerson.getFirstName());
        personToBeUpdated.setLastName(updatedPerson.getLastName());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
