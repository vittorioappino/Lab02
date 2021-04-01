package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	private List<WordEnhanced> lista;
	
	public AlienDictionary() {
		this.lista = new ArrayList<>();
	}

	public void addWord(String alienWord, String translation) {
		WordEnhanced word = new WordEnhanced(alienWord, translation);
		for(WordEnhanced w: lista) {
			if(w.equals(word)) {
				w.setTranslation(translation);
				return;
			}
		}
		lista.add(word);
	}
	
	public String translateWord(String alienWord) {
		for(WordEnhanced w: lista) {
			if(w.getAlienWord().equals(alienWord)) {
				return w.getTranslation();
			}
		}
		return "la parola non è presente nel dizionario";
		
	}
	
	public void doReset() {
		lista.clear();
	}

	public String translateWordWildCard(String alienWildCard) {
		alienWildCard = alienWildCard.replaceAll("\\?", ".");

		int matchCounter = 0;
		StringBuilder sb = new StringBuilder();

		for (WordEnhanced w : lista) {
			if (w.compareWild(alienWildCard)) {
				matchCounter++;
				sb.append(w.getTranslation() + "\n");
			}
		}
		
		if (matchCounter != 0)
			return sb.toString();
		else
			return null;
	}
}
