
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextAreaStudy extends Application {

	@Override
	public void start(Stage primaryStage) {
		TextArea ta = new TextArea();
		Button bt = new Button("getText");
		Button bt2 = new Button("setText");
		
		bt.setOnAction(e->{
			String text = ta.getText();
			System.out.println(text);
		});
		bt2.setOnAction(e->{
			ta.setText("ÀÚ¹Ù ±ÍÂú´Ù");
		});
		VBox vb = new VBox(ta,bt,bt2);
		
		Scene scene = new Scene(vb,500,500);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("textAreaStudy");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
