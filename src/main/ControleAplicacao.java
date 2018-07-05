package main;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import main.Conversor;

public class ControleAplicacao {

	 @FXML
	 TextField saida;

	 @FXML
	 TextField entrada;

	 public void converte() {
		 saida.setText(Conversor.converter(entrada.getText()));

	 }
	 public void clean(){
		 saida.setText(null);
	 }


}
