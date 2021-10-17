
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RandomNumber extends Application {
	
	
	int answer;
	@Override
	public void start(Stage primaryStage) {
//		
//		Random random = new Random();
//		
//		int number = random.nextInt(10)+1;
//		
//		
//		//문자열 숫자로
//		try {
//		int a = Integer.parseInt("4a");
//		}catch(Exception e) {
//			System.out.println("숫자로 바꿀수 없는 문자열이 있습니다.");
//		}
		
		TextField tf = new TextField();
		tf.setPromptText("GUI");
		
		Label infoLb = new Label("Enter a Number from 1 to 10");
		Label resultLb = new Label("Result");
		
		
		answer = new Random().nextInt(10)+1;
		
		
		tf.setOnAction(e->{
			try {
			int number = Integer.parseInt(tf.getText().trim());
			
			if (answer == number) {
				resultLb.setText("정답입니다.");
				answer = new Random().nextInt(10)+1;
			}else {
				resultLb.setText("틀렸습니다");
			}
			}catch(Exception e2) {
				System.out.println("숫자만 입력해주세요");
			}
		});
		
		VBox vb = new VBox(infoLb,tf,resultLb);
		vb.setSpacing(2);
		vb.setPadding(new Insets(2));
		
		Scene scene = new Scene(vb,500,500);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("숫자 맞추기게임");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
