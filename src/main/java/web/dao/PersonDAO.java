package web.dao;

import web.Models.Person;

public interface PersonDAO {
    Person show(int id);
    void save(Person person);
    void update(int id, Person updatedPerson);
    void delete(int id);
}
