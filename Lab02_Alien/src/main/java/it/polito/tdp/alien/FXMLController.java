package it.polito.tdp.alien;

import java.io.BufferedReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private AlienDictionary Dizionario = new AlienDictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField TxtInserisci;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea TxtMostra;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {
    	TxtMostra.clear();
    	TxtInserisci.clear();
    	Dizionario.doReset();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	TxtMostra.clear();
    	String riga = TxtInserisci.getText().toLowerCase();
    	if(riga.isEmpty()){
			TxtMostra.setText("Nessuna parola inserita");
			return;
		}else {
			String[] array;
			array = riga.split(" ");
	    	if(array.length==1) {
	    		String traduzione;
	    		if (!array[0].matches("[a-zA-Z?]*")) {
					TxtMostra.setText("Inserire solo caratteri alfabetici.");
					return;
				}
	    		if (array[0].matches("[a-zA-Z?]*") && !array[0].matches("[a-zA-Z]*")) {
					traduzione = Dizionario.translateWordWildCard(array[0]);
					TxtMostra.setText(traduzione);
					return;
				} 
	    		traduzione= Dizionario.translateWord(array[0]);
	    		TxtMostra.setText(traduzione);
	    	}
	    	if(array.length==2) {
	    		if (!array[0].matches("[a-zA-Z]*") || !array[1].matches("[a-zA-Z]*")) {
					TxtMostra.setText("Inserire solo caratteri alfabetici.");
					return;
				}
	    		Dizionario.addWord(array[0], array[1]);
	    	}
    	}
    	TxtInserisci.clear();
    }

    @FXML
    void initialize() {
        assert TxtInserisci != null : "fx:id=\"TxtInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert TxtMostra != null : "fx:id=\"TxtMostra\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
