package MiniProjetTestMock;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DictionaryMain {

	public static void main(String[] args) throws IOException {
		Dictionary dictionary = new Dictionary();
		
		System.out.println("Projet GL\n");
		
		dictionary.addTranslation("travail", "work");
		dictionary.addTranslation("voiture", "car");
		dictionary.addTranslation("ballon", "ball");
				
		System.out.println(dictionary.getTranslation("travail"));
		System.out.println(dictionary.getTranslation("voiture"));
		System.out.println(dictionary.getTranslation("ballon"));
		//test introuvable
		System.out.println(dictionary.getTranslation("test"));
		
		
		//test multi traduction
		Dictionary multidictionary = new Dictionary();
		multidictionary.addMultipleTranslation("travail", "work");
		multidictionary.addMultipleTranslation("voiture", "car");
		multidictionary.addMultipleTranslation("travail", "job");
		
		System.out.println(multidictionary.getMultipleTranslations("travail"));
		
		System.out.println(multidictionary.getBiMultiTranslation("car"));
		System.out.println(multidictionary.getBiMultiTranslation("job"));
		
		
		try {
			FileParser fileparser = new FileParser("dictionary.txt");
			dictionary = fileparser.alimentationDictionary();
			System.out.println(dictionary.getBiMultiTranslation("father"));
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
