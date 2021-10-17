
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonStudy3 extends Application {

	@Override
	public void start(Stage primaryStage) {
		// ()안에는 버튼에 들어갈 문구
		Button bt =new Button("클릭");
		
		VBox vb =new VBox(bt);
		
		bt.setOnAction(e -> {
			System.out.println("버튼을 클릭하였다");
		});
		
		Scene scene = new Scene(vb,500,500);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("버튼창");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
