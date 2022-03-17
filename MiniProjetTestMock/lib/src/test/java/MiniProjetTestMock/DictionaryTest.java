package MiniProjetTestMock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import MiniProjetTestMock.Dictionary;

class DictionaryTest {
	HashMap<String, String> dictionaryMap = new HashMap<String, String>();
	Dictionary dictionary1 = new Dictionary("dictionary1"); 
	Dictionary dictionary2 = new Dictionary("dictionary2");
	Dictionary multidictionary = new Dictionary();
	

	@Test
	void checkDictionary() {
		Dictionary dictionary = new Dictionary(null);
		assertEquals(null,dictionary.getMot());
	}
	
	@Test
	public void testgetName() {	
		assertEquals("dictionary1", dictionary1.getMot());	 
		assertEquals("dictionary2", dictionary2.getMot());		
	}
	
	@Test
	public void empty()
	{
		if(!dictionaryMap.isEmpty())
		{
			fail("Le dictionnaire est bien vide !");
		}
	}
	
	@Test
	public void testSpecialChar() {
		//dictionaryMap.put("tes@t", "caracterespecial");
		for(String i : dictionaryMap.keySet())
		{
		 try {
			 Pattern p = Pattern.compile("[^A-Za-z]");
		     Matcher m = p.matcher(i);
		     boolean b = m.find();
		     if (b) {
		       	 fail("le mot contient un charactère spécial!");
		     
		     }else {
		         System.out.println("Il n'esiste plus de charactère spécial!");
		     }
		    } catch (Exception e) {
		       
		    }
	}
	}
	
	@Test
	void addTranslationTest() {
		dictionaryMap.put("fr", "en");
		dictionaryMap.put("mot", "word");
		dictionaryMap.put("voiture", "car");
		dictionaryMap.put("ballon", "ball");

		assertFalse(dictionaryMap.isEmpty());
		// Pour verifier la taille du tableau
		assertEquals(4, dictionaryMap.size());
	}

	@Test
	void getTranslationTest() {

		dictionaryMap.put("fr", "en");
		dictionaryMap.put("mot", "word");
		dictionaryMap.put("voiture", "car");
		dictionaryMap.put("ballon", "ball");
		dictionaryMap.put("ballon", "football");

		// retourne la valeur de la cle correspondante
		assertEquals("en", dictionaryMap.get("fr"));

		// test l'ajout d'un element qui remplace le precedent avec la même cle
		assertEquals("football", dictionaryMap.get("ballon"));

		// ce test retourne true si la cle existe
		assertTrue(dictionaryMap.containsKey("fr"));

		// ce test retourne false si la cle n'existe pas
		assertFalse(dictionaryMap.containsKey("java"));

	}
	
	@Test
	public void checkMultiDictionary() 
	{
		multidictionary.addMultipleTranslation("fr", "en");
		
		if(multidictionary.getMultiDictionaryMap().isEmpty()) 
		{
			fail("Dictionnaire multiple est vide !");
		}
		if(!multidictionary.getMultiDictionaryMap().containsKey("mot"))
		{
			System.out.println("Le mot <mot> n'existe pas !");
		}
	}
	
	@Test
	public void testaddMultipleTranslation() {
		List<String> motliste = new ArrayList<>();
		
		motliste.add("eng");
		motliste.add("ang");
		
		multidictionary.addMultipleTranslation("fr", motliste.get(0));
		multidictionary.addMultipleTranslation("fr", motliste.get(1));
		
		if(!multidictionary.getMultiDictionaryMap().isEmpty()) {
			assertEquals(motliste,multidictionary.getMultiDictionaryMap().get("fr"));
		}
		else{
			fail("Erreur d'ajout multiple !");
		}
			
	}
	
	@Test
	public void checkBiMultipleTranslation()
	{
		List<List<String>> listValues = new ArrayList<List<String>>();
	    List<String> listKeys = new ArrayList<String>();
		String key = "mot";
		
		multidictionary.addMultipleTranslation(key, "word");
		
		if(multidictionary.getMultiDictionaryMap().isEmpty()) 
		{
			fail("Dictionnaire multiple est vide !");
		}
		if(!multidictionary.getMultiDictionaryMap().containsKey(key))
		{
			fail("Le mot <mot> n'existe pas !");
		}
		
	      
	      for (String i : multidictionary.getMultiDictionaryMap().keySet()) {
	    	  listKeys.add(i);
	    	}
	      
	      for (List<String> j : multidictionary.getMultiDictionaryMap().values()) {
	    	  listValues.add(j);
	    	}
	      
	      
	      if(!(listKeys.contains(key)))
	      {
	    	  for(int i = 0 ; i < listValues.size();i++)
		      {
		    	 if(!(listValues.get(i).toString().contains(key)))
		    	 {
			    	fail("Le mot n'existe pas dans le dictionnaire ni en anglais ni en francais !");
		    	 }   
		      }
	      }
	}
	
	
	 
	

}


