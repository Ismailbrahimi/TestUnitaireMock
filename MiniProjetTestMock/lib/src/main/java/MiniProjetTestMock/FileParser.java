package MiniProjetTestMock;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileParser {

	private BufferedReader bufferedreader;
	private String mot;
	private FileReader file = null;

	public FileParser(String filename) throws IOException, FileNotFoundException {
		Path path = Paths.get(filename);

		file = new FileReader(path.toAbsolutePath().toString());

		if (file.ready()){
			bufferedreader = new BufferedReader(file);

		} else {
			System.out.println("Fichier introuvable !!");
			throw new FileNotFoundException();
		}

	}

	public BufferedReader getBufferedreader() {
		return bufferedreader;
	}

	public String readMot() throws IOException {

		mot = bufferedreader.readLine();
		return mot;
	}

	public String[] parseLine(String line) {
		String[] columns = line.split(";");
		return columns;

	}

	public Dictionary alimentationDictionary() throws IOException {
		String strCurrentLine;
		int i = 0;
		readMot();
		Dictionary dictionary = new Dictionary(mot);
		while ((strCurrentLine = bufferedreader.readLine()) != null) {

			String[] columns = parseLine(bufferedreader.readLine());
			if (i > 0) {
				String mot1 = columns[0];
				String mot2 = columns[1];
				dictionary.addMultipleTranslation(mot1, mot2);
				
			} else {
				String mot = columns[0];
				System.out.println(mot);
				i++;
			}
		}
		return dictionary;

	}
	
}

