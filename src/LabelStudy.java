
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LabelStudy extends Application {

	@Override
	public void start(Stage primaryStage) {
		Label lb = new Label("study");
		
		Button bt = new Button("클릭");
		Button bt2 = new Button("클릭");
		
		bt.setOnAction(e->{
			lb.setText("안녕하세요");
		});
		
		bt2.setOnAction(e->{
			String a = lb.getText();
			System.out.println("라벨 텍스트 : " + a);
		});
		
		VBox vb = new VBox(lb,bt,bt2);
		
	
		
		Scene scene = new Scene(vb,500,500);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("라벨");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
