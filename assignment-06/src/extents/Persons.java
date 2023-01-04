package extents;

import lists.Nationality;
import lists.Person;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class Persons{

    private static Set<Person> instance;
    private static List<Person> personsList;

    static {
        instance = new HashSet<>();
        personsList =new ArrayList<>();
    }

    public static void add(Person person){
        instance.add(person);
        personsList.add(person);
        personsList.sort(Comparator.naturalOrder());
    }

    public static Set <Person> instance(){
        return instance;
    }
    public static List<Person> filterByNationality(Nationality nationality) {
        List<Person> p = personsList
                .stream()
                .filter(e -> e.getNationality() == nationality)
                .collect(Collectors.toList());

        Collator nat_Collator = nationality.getCollator();
        Comparator<Person> nat_comparator = Comparator
                .comparing(Person::getSurname, nat_Collator)
                .thenComparing(Person::getFirstName, nat_Collator);

        p.sort(nat_comparator);
        return p;
    }

}
