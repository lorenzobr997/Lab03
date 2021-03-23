package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	Dictionary dizionario;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> choice;
    
    public void setModel(Dictionary m) {
    	this.dizionario = m;
    	this.choice.getItems().addAll("English","Italiano");
    }
    

    @FXML
    private TextArea words;

    @FXML
    private TextArea wrongWords;

    @FXML
    private Label nerrors;

    @FXML
    private Button clear;

    @FXML
    private Label time;

    @FXML
    void handleChoice(ActionEvent event) {
    	String lingua = choice.getValue();
    	dizionario.loadDictionary(lingua);
    }

    @FXML
    void handleClear(ActionEvent event) {

    }

    @FXML
    void hanleSpell(ActionEvent event) {
    	String testo = this.words.getText();
    	testo.replaceAll("[.,\\/#!?%\\^&\\*;:{}=\\-_'()\\[\\]\"]", "");
    	String[] parts = testo.split(" ");
    	ArrayList<String> input = new ArrayList<>();
    	
    	for(int i = 0; i < parts.length; i++) {
    		input.add(parts[i]);
    	}
    	
    	List<RichWord> errori = dizionario.spellCheckTest(input);
    	wrongWords.appendText(errori.toString());
    }

    @FXML
    void initialize() {
        assert choice != null : "fx:id=\"choice\" was not injected: check your FXML file 'Scene.fxml'.";
        assert words != null : "fx:id=\"words\" was not injected: check your FXML file 'Scene.fxml'.";
        assert wrongWords != null : "fx:id=\"wrongWords\" was not injected: check your FXML file 'Scene.fxml'.";
        assert nerrors != null : "fx:id=\"nerrors\" was not injected: check your FXML file 'Scene.fxml'.";
        assert clear != null : "fx:id=\"clear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert time != null : "fx:id=\"time\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}



