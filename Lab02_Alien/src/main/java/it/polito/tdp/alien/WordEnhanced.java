package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class WordEnhanced {
	
	private String alienWord;
	private List<String> translations;
	
	public WordEnhanced(String alienWord, String translation) {
		this.alienWord= alienWord;
		this.translations = new ArrayList<String>();
		this.translations.add(translation);
	}
	
	public WordEnhanced(String alienWord) {
		this.alienWord= alienWord;
		this.translations = new ArrayList<String>();
	}
	
	public String getAlienWord() {
		return alienWord;
	}
	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}
	public String getTranslation() {
		String s = "";
		for (String a : translations) {
			s += a + "\n";
		}
		return s;
	}
	public void setTranslation(String translation) {
		if (!translations.contains(translation)) {
			translations.add(translation);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordEnhanced other = (WordEnhanced) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}
	
}
