
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextFieldStudy extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		TextField tf = new TextField();
		
		tf.setPromptText("Search");

		Button bt = new Button("텍스트 가져오기");
		Button bt2 = new Button("텍스트 내보내기");
		
		bt.setOnAction(e ->{
			String a =tf.getText().trim();
			System.out.println(a);
		});
		
		bt2.setOnAction(e ->{
			tf.setText("꽝이다");
			
		});
		
		tf.setOnAction(e ->{
//			System.out.println("dsadsads");
			// 버튼의 함수 가져오기
			bt2.fire();
		});
		
		VBox vb = new VBox(tf,bt,bt2);
		
		
		Scene scene = new Scene(vb,500,500);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("텍스트필드");
				
	}

	public static void main(String[] args) {
		launch(args);
	}
}
