package main;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class MainApp extends Application {


	 public static void main(String[] args) {
		  launch();
		 }

		 @Override
		 public void start(Stage palco) throws Exception {
		  URL arquivoFXML = getClass().getResource(
		    "/view/conversor.fxml");
		  Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
		  palco.setScene(new Scene(fxmlParent));
		  palco.setTitle("Conversor");
		  Image applicationIcon = new Image(getClass().getResourceAsStream("/resources/icon.png"));
		  palco.getIcons().add(applicationIcon);
		  palco.show();

		 }


	}

