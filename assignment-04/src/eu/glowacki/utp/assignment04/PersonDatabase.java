package eu.glowacki.utp.assignment04;

import eu.glowacki.utp.assignment04.comparators.BirthdateComparator;
import eu.glowacki.utp.assignment04.comparators.FirstNameComparator;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public final class PersonDatabase {

	private static List<Person> listik;

		public PersonDatabase(List<Person> input) {
			this.listik = input;

	}

	public List<Person> sortedByFirstName() {
		Comparator <Person> NameComparator = new FirstNameComparator();
		List <Person> sortedByName = new ArrayList<>();
		sortedByName.addAll(listik);
		sortedByName.sort(NameComparator);
		return sortedByName; // external rule for ordering (based on Comparator --- FirstNameComparator)
	}

	public List<Person> sortedBySurnameFirstNameAndBirthdate() {
		Comparator <Person> nature = Comparator.naturalOrder();
		List <Person> sortedByAll = new ArrayList<>();
		sortedByAll.addAll(listik);
		sortedByAll.sort(nature);

		return sortedByAll; // natural order (Comparable)
	}
	
	public List<Person> sortedByBirthdate() {
		Comparator <Person> birthComparator = new BirthdateComparator();
		List <Person> sortedByBirthday = new ArrayList<>();
		sortedByBirthday.addAll(listik);
		sortedByBirthday.sort(birthComparator);

		return sortedByBirthday; // external rule for ordering (based on Comparator --- BirthdateComparator)
	}
	
	public List<Person> bornOnDay(Date date) {
		List<Person> sortedList = sortedByFirstName();

		Map<Date, List<Person>> groupingByDate = sortedList
				.stream()
				.collect(Collectors.groupingBy(Person::getBirthdate, TreeMap::new, Collectors.mapping(e -> e,
						Collectors.toList())));
		return groupingByDate.get(date);
	}

}