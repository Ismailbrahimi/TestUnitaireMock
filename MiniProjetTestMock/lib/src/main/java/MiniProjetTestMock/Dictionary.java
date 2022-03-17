package MiniProjetTestMock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Dictionary {
	private String mot;

	// uni traduction
	private HashMap<String, String> dictionaryMap = new HashMap<String, String>();
//	private static final String FILENAME = "DictionaryTextFile\\dictionary.txt";

	public Dictionary() {
	}

	public Dictionary(String mot) {
		super();
		this.mot = mot;
	}

	public HashMap<String, String> getDictionaryMap() {
		return dictionaryMap;
	}

	public void setDictionaryMap(HashMap<String, String> dictionaryMap) {
		this.dictionaryMap = dictionaryMap;
	}

	public HashMap<String, List<String>> getMultiDictionaryMap() {
		return multiDictionaryMap;
	}

	public void setMultiDictionaryMap(HashMap<String, List<String>> multiDictionaryMap) {
		this.multiDictionaryMap = multiDictionaryMap;
	}

	// deuxieme phase : multipleTraduction
	private HashMap<String, List<String>> multiDictionaryMap = new HashMap<String, List<String>>();

	public String getMot() {
		return mot;
	}

	public void setMot(String mot) {
		this.mot = mot;
	}

	void addTranslation(String fr, String en) {

		if (!dictionaryMap.containsKey(fr)) {
			dictionaryMap.put(fr, en);
			System.out.println("\n" + fr + ": est ajouté avec succès!");
		} else {
			System.out.println("Ce mot est déjà existant!");
		}
	}

	String getTranslation(String key) {
		String val = "introuvable";

		System.out.println("\nRecherche de la traduction du mot : " + key);
		for (String i : dictionaryMap.keySet()) {
			if (i.equals(key)) {
				val = dictionaryMap.get(i);
			}
		}
		return "la traduction est : " + val;
	}

	public void addMultipleTranslation(String fr, String en) {
		List<String> val = new ArrayList<String>();

		if (multiDictionaryMap.containsKey(fr)) {
			val = multiDictionaryMap.get(fr);
			val.add(en);
			multiDictionaryMap.replace(fr, val);
			System.out.println("\n" + fr + ": est ajouté avec succès!");
		} else {
			val.add(en);
			multiDictionaryMap.put(fr, val);
			System.out.println("\n" + fr + ": est ajouté avec succès!");
		}
	}

	public String getMultipleTranslations(String key) {
		System.out.println("\nRecherche de la traduction unidirectionnelle multiple de : " + key);
		return "Les traductions existantes sont : " + multiDictionaryMap.get(key);
	}

	public String getBiMultiTranslation(String key) {
		System.out.println("\nRecherche de la traduction bidirectionnelle multiple de : " + key);
		List<String> val = new ArrayList<>();
		List<List<String>> listValues = new ArrayList<List<String>>();
		List<String> listKeys = new ArrayList<String>();

		for (String i : multiDictionaryMap.keySet()) {
			listKeys.add(i);
		}

		for (List<String> j : multiDictionaryMap.values()) {
			listValues.add(j);
		}

		if (listKeys.contains(key)) {
			val = multiDictionaryMap.get(key);
		}

		for (int i = 0; i < listValues.size(); i++) {
			if (listValues.get(i).toString().contains(key)) {
				val.add(listKeys.get(i));
			}

		}
		return "Les traductions existantes sont : " + val;
	}


}

