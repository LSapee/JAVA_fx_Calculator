
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

public class CalculatorGUI extends Application {
	
	
	int answer;
	@Override
	public void start(Stage primaryStage) {
		
		TextField f = new TextField();
		TextField s = new TextField();
		
		Button addbt = new Button("add");
		Button subbt = new Button("sub");
		Button mulbt = new Button("mul");
		Button divbt = new Button("div");
		
		Button num1 = new Button("1");
		Button num2 = new Button("2");
		Button num3 = new Button("3");
		Button num4 = new Button("4");
		Button num5 = new Button("5");
		Button num6 = new Button("6");
		Button num7 = new Button("7");
		Button num8 = new Button("8");
		Button num9 = new Button("9");
		Button num0 = new Button("0");
		
		Label resultLb = new Label("Result");
		
		HBox hb = new HBox(f,s);
		HBox hb2 = new HBox(addbt,subbt,mulbt,divbt);
		hb.setSpacing(2);
		hb2.setSpacing(2);
		
		//event
		addbt.setOnAction(e->{
			try {
			int first = Integer.parseInt(f.getText().trim());
			int second = Integer.parseInt(s.getText().trim());
			
			int sum = first + second;
			
			resultLb.setText("sum : " + sum);
			}catch(Exception e2) {
				System.out.println("숫자만 입력해주세요");
			}
		});
		subbt.setOnAction(e->{
			try {
				int first = Integer.parseInt(f.getText().trim());
				int second = Integer.parseInt(s.getText().trim());
				
				int sub = first - second;
				
				resultLb.setText("sub : " + sub);
				}catch(Exception e2) {
					System.out.println("숫자만 입력해주세요");
				}
		});
		mulbt.setOnAction(e->{
			try {
				int first = Integer.parseInt(f.getText().trim());
				int second = Integer.parseInt(s.getText().trim());
				
				int mul = first * second;
				
				resultLb.setText("mul : " + mul);
				}catch(Exception e2) {
					System.out.println("숫자만 입력해주세요");
				}
		});
		divbt.setOnAction(e->{
			try {
				int first = Integer.parseInt(f.getText().trim());
				int second = Integer.parseInt(s.getText().trim());
				
				float div = (float)(first) / (float)(second);
				
				resultLb.setText("div : " + div);
				}catch(Exception e2) {
					System.out.println("숫자만 입력해주세요");
				}
		});
		
		
		VBox vb = new VBox(hb,hb2,resultLb);
		vb.setSpacing(2);
		vb.setPadding(new Insets(2));
		
		Scene scene = new Scene(vb,500,500);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Hbox");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
