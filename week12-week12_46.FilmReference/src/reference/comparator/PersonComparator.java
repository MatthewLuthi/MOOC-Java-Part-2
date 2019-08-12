package reference.comparator;

import java.util.Comparator;
import java.util.Map;
import reference.domain.Person;

public class PersonComparator implements Comparator<Person> {
    private Map<Person, Integer> people;
    
    public PersonComparator(Map<Person, Integer> peopleIdentities) {
        people = peopleIdentities;
        
    }

    @Override
    public int compare(Person person1, Person person2) {
        return people.get(person2) - people.get(person1);
    } 
}
