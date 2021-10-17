
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HBoxStudy extends Application {
	
	
	int answer;
	@Override
	public void start(Stage primaryStage) {
		
		Button bt1 = new Button("bt1");
		Button bt2 = new Button("bt2");
		Button bt3 = new Button("bt3");
		
		HBox hbox = new HBox(bt1,bt2,bt3);
		
		Scene scene = new Scene(hbox,500,500);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Hbox");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
