package eu.glowacki.utp.assignment04;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public final class InputParser {
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
	private static final String linePattern = "[a-zA-Z]+\\s[a-zA-Z]+\\s[0-2][0-9]{3}\\-[0-1][0-9]\\-[0-3][0-9]";

	public static List<Person> parse(File file) {
		List<Person> listik = new ArrayList<>();
		try {
			//создаем объект FileReader для объекта File
			FileReader fr = new FileReader(file);
			//создаем BufferedReader с существующего FileReader для построчного считывания
			BufferedReader reader = new BufferedReader(fr);
			// считаем сначала первую строку
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				if (!Pattern.matches(linePattern, line)){
					continue;
				}
				String[] arr = line.split(" ");
				if (arr.length < 3) {
					continue;
				}
				String firstName = arr[0];
				String surname = arr[1];
				Date birthdayDate = null;
				try {
					birthdayDate = dateFormat.parse(arr[2]);
				} catch (ParseException e) {
					continue;
				}

				listik.add(new Person(firstName, surname, birthdayDate));
				// считываем остальные строки в цикле
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


		// 1. Use regular expresssions (Pattern) for validating input data
		//    U�y� regularnych wyra�e� (Pattern) do walidacji danych wej�ciowych
		//
		// 2. Convert input string representing date using SimpleDateFormat "yyyy-MM-dd"
		//    Konwersj� wej�ciowego ci�gu znak�w reprezentuj�cego dat� nale�y oprze� np. DateFormat
		//    SimpleDateFormat format "yyyy-MM-dd"


		return listik;
	}
}