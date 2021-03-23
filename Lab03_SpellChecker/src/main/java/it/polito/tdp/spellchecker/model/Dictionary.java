package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
	
	public void loadDictionary (String language) {
		String load = "src/main/resources/" + language + ".txt";
		ArrayList<RichWord> dizionario = new ArrayList<>();
		
		try {
			FileReader fr = new FileReader(load);
			BufferedReader br = new BufferedReader(fr);
			
			String word;
			RichWord w;
			while((word = br.readLine()) != null) {
				w = new RichWord(word);
				dizionario.add(w);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("ERRORE NELLA LETTURA DEL FILE");
		}
		
	}

	
	
	public List<RichWord> spellCheckTest(List<String> inputTxtList){
		return null;
	}

}
