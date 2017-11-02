package pl.kobietydokodu.koty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

import pl.kobietydokodu.koty.dao.impl.SimpleKotDAO;
import pl.kobietydokodu.koty.domain.Cat;

public class Interfejs {

    static Scanner sc = new Scanner(System.in);
    
    static SimpleKotDAO kotDao = new SimpleKotDAO();

    public static void main(String[] args) {
    	String wyborUzytkownika;
    	do {
    		System.out.println();
    		System.out.println("Wybierz, co chcesz zrobić, a następnie zatwierdź enterem:");
	    	System.out.println("[1] Dodaj nowego kota");
	    	System.out.println("[2] Pokaż wszystkie koty");
	    	System.out.println("[x] Zakończ");
			wyborUzytkownika = getUserInput();
	    	if (wyborUzytkownika.equals("1")) {
	    		dodajKota();
	    	} else if (wyborUzytkownika.equals("2")) {
	    		pokazKoty();
	    	}
    	} while (!wyborUzytkownika.equalsIgnoreCase("x"));
        
    }

	private static void pokazKoty() {
		System.out.println();
		System.out.println("#########################################################");
		System.out.println("######                 LISTA KOTÓW                 ######");
		System.out.println("#########################################################");
		
		Cat kot;
		for (int i=0; i<kotDao.findAll().size(); i++) {
			kot = kotDao.findAll().get(i);
			System.out.println(i + ": " + kot.getName());
		}
		System.out.println();
		Pattern wzorzecNumeru = Pattern.compile("[0-9]+");
		String numerWczytany;
		do {
			System.out.print("Którego kota chcesz poznać bliżej? ");
			numerWczytany = getUserInput();
		} while (!wzorzecNumeru.matcher(numerWczytany).matches());
		
		Integer numerKota = Integer.parseInt(numerWczytany);
		if (kotDao.findAll().size()>numerKota) {
			Cat wybranyKot = kotDao.findAll().get(numerKota);
			System.out.println("Wybrany kot ma na imie "+wybranyKot.getName()+", waży "+wybranyKot.getWeight()+", urodził się "+wybranyKot.getBirthDate().toString()+", a opiekuje się nim "+wybranyKot.getOwner());
		} else {
			System.out.println("Niestety, nie znalazłem kota o wybranym numerze :( Sprobój ponownie lub go dodaj!");
		}
	}

	private static void dodajKota() {
		System.out.println();
		System.out.println("#########################################################");
		System.out.println("######                 DODAJ  KOTA                 ######");
		System.out.println("#########################################################");
		Cat kot = new Cat();
		System.out.print("Podaj imię kota: ");
        kot.setName(getUserInput());

        Pattern wzorzecDaty = Pattern.compile("[0-9]{4}.[0-1]?[0-9].[0-3]?[0-9]");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String dataUrodzeniaWczytana;
        do {
            System.out.print("Podaj datę urodzenia kota w formacie RRRR.MM.DD: ");
            dataUrodzeniaWczytana = getUserInput();
            if (wzorzecDaty.matcher(dataUrodzeniaWczytana).matches()) {
            	/*try {
            		kot.setBirthDate(sdf.parse(dataUrodzeniaWczytana));
            	} catch (ParseException pe) {
            		System.out.println("Coś jest nie tak z datą! Przykładowa data: 2014.01.05");
            	}*/
            }
        } while (kot.getBirthDate()==null);
        
        Pattern wzorzecWagi = Pattern.compile("[0-9]+(\\.[0-9]+)?");
        String wagaWczytana;
        do {
            System.out.print("Podaj wagę kota: ");
            wagaWczytana = getUserInput();
            
            if (wzorzecWagi.matcher(wagaWczytana).matches()) {
                kot.setWeight(Float.valueOf(wagaWczytana));
            }
        } while (kot.getWeight() == null);

        System.out.print("Podaj kto jest opiekunem kota: ");
        kot.setOwner(getUserInput());

        kotDao.add(kot);
        
        System.out.println("Dziękuję, teraz wiem o kocie naprawdę wszystko! Dodałem go do naszego zbioru.");
	}

    public static String getUserInput() {
        return sc.nextLine().trim();
    }

}
