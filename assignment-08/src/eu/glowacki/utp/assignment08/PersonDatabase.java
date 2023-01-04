package eu.glowacki.utp.assignment08;

import eu.glowacki.utp.assignment08.comparators.BirthdateComparator;
import eu.glowacki.utp.assignment08.comparators.FirstNameComparator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.*;
import java.util.stream.Collectors;

public final class PersonDatabase {
	private static final Comparator<Person> CompareByNameSurnameBirthdate = Comparator.naturalOrder();
	private static final Comparator<Person> CompareByName = new FirstNameComparator();
	private static final Comparator<Person> CompareByBirthdate = new BirthdateComparator();
	List<Person> listik;

	public PersonDatabase(List<Person> people) {
		listik = people;
	}

	// assignment 8 - factory method based on deserialization
	public static PersonDatabase deserialize(DataInputStream input) throws Assignment08Exception {
		try{
			int length = input.readInt();
			List<Person> people = new ArrayList<>();
			for (int i = 0; input.available() > 0 && i<length; i++){
			Person person = Person.deserialize(input);
			people.add(person);
			}
			return new PersonDatabase(people);
		} catch (Throwable exception) {
			throw new Assignment08Exception(exception.getMessage(), exception);
		}
	}

	// assignment 8
	public void serialize(DataOutputStream output) throws Assignment08Exception {

			/*output.writeInt(sortedBySurnameFirstNameAndBirthdate().size());
			sortedBySurnameFirstNameAndBirthdate().forEach(p -> {
				try {
					p.serialize(output);
				} catch (Assignment08Exception e) {
					e.printStackTrace();
				}
			});
		}catch (Throwable exception){
			throw new Assignment08Exception(exception);
		}

			 */

		try {
			Collections.sort(listik);
			output.writeInt(listik.size());
			listik.forEach(p ->
			{
				try {
					p.serialize(output);
				} catch (Throwable exception) {
					exception.getStackTrace();
				}
			});
		}catch (Throwable exception) {
			throw new Assignment08Exception(exception.getMessage(), exception);
		}

	}


	private final List<Person> sortedByNameSurnameBirthdate = new ArrayList<>();
	private List<Person> sortedByName = new ArrayList<>();
	List <Person> sortedByBirthday = new ArrayList<>();



	// assignment 4
	public List<Person> sortedByFirstName() {

		sortedByName = new ArrayList<>(listik);
		sortedByName.sort(CompareByName);

		return sortedByName;
	}

	// assignment 4
	public List<Person> sortedBySurnameFirstNameAndBirthdate() {
		sortedByNameSurnameBirthdate.addAll(listik);
		sortedByNameSurnameBirthdate.sort(CompareByNameSurnameBirthdate);

		return sortedByNameSurnameBirthdate;
	}

	// assignment 4
	public List<Person> sortedByBirthdate() {
		sortedByBirthday.addAll(listik);
		sortedByBirthday.sort(CompareByBirthdate);

		return sortedByBirthday;
	}

	// assignment 4
	public List<Person> bornOnDay(Date date) {
		List<Person> sortedList = sortedByFirstName();

		Map<Date, List<Person>> groupingByDate = sortedList
				.stream()
				.collect(Collectors.groupingBy(Person::getBirthDate, TreeMap::new, Collectors.mapping(e -> e,
						Collectors.toList())));
		return groupingByDate.get(date);
	}
}