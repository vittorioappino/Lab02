package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	private List<Word> lista;
	
	public AlienDictionary() {
		this.lista = new ArrayList<>();
	}

	public void addWord(String alienWord, String translation) {
		Word word = new Word(alienWord, translation);
		for(Word w: lista) {
			if(w.equals(word)) {
				w.setTranslation(translation);
				return;
			}
		}
		lista.add(word);
	}
	
	public String translateWord(String alienWord) {
		for(Word w: lista) {
			if(w.getAlienWord().equals(alienWord)) {
				return w.getTranslation();
			}
		}
		return null;
		
	}
	
	public void doReset() {
		lista.clear();
	}
}
