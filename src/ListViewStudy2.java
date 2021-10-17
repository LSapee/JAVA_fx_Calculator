
import java.util.Observable;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewStudy2 extends Application {

	@Override
	public void start(Stage primaryStage) {
		ListView<String> lv = new ListView<>();
		
		
		ObservableList<String> ov = FXCollections.observableArrayList();
		
		lv.setItems(ov);
		
		ov.addAll("Good","Normal","Best","Superb");
		
		
		lv.setOnMouseClicked(e->{
			System.out.println("mouse click");
			
			String aa = lv.getSelectionModel().getSelectedItem();
			int index = lv.getSelectionModel().getSelectedIndex();
			
			if(aa != null) {
				
				System.out.println("Index : " + index + "\nSelected :" + aa );
			}
			
			
		});
		
		
		lv.getSelectionModel().selectedItemProperty().addListener((a,oldValue,newValue)->{
			System.out.println(oldValue);
			System.out.println(newValue);
		});
		
		
		VBox vb = new VBox(lv);
		
		Scene scene = new Scene(vb,500,500);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("ししいけしいけ");
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
