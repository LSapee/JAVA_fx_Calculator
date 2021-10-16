
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LabelStudy extends Application {

	@Override
	public void start(Stage primaryStage) {
		Label lb = new Label("study");
		
		VBox vb = new VBox(lb);
		
		Scene scene = new Scene(vb,500,500);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("¶óº§");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
