
import java.util.Observable;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewStudy extends Application {

	@Override
	public void start(Stage primaryStage) {
		ListView<String> lv = new ListView<>();
		
		
		ObservableList<String> ov = FXCollections.observableArrayList();
		
		lv.setItems(ov);
		
		Button bt1 = new Button("add");		
		Button bt2 = new Button("remove");		
		Button bt3 = new Button("updata");		
		Button bt4 = new Button("Contain");		
		
		bt1.setOnAction(e->{
			ov.add("Good");
			ov.add("day");
			ov.addAll("sdads","dsadsa");
		});
		bt2.setOnAction(e->{
			ov.remove("Good");
			ov.removeAll("Good");
		});
		bt3.setOnAction(e->{
			//
			ov.set(0, "first");
			ov.set(1, "Second");
		});
		bt4.setOnAction(e->{
			if(ov.contains("first")) {
				System.out.println("Contain");
			}else {
				System.out.println("Does not Dontain");
			}
		});
		
		
		
		VBox vb = new VBox(lv,bt1,bt2,bt3,bt4);
		
		Scene scene = new Scene(vb,500,500);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("ししいけしいけ");
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
