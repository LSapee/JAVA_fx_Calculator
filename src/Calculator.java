
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {
	
	
	int answer;
	@Override
	public void start(Stage primaryStage) {
		
		
		ListView<String> lv = new ListView<>();
		lv.setMaxHeight(100);
		ObservableList<String> ov = FXCollections.observableArrayList();
		lv.setItems(ov);
		


		TextField tf = new TextField();
		
		
		Button addbt = new Button("+");
		Button subbt = new Button("-");
		Button mulbt = new Button("x");
		Button divbt = new Button("/");
		Button eqbt = new Button("=");
		Button clearbt = new Button("C");
		
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
		
		HBox hb1 = new HBox(num7,num8,num9,mulbt);
		HBox hb2 = new HBox(num4,num5,num6,subbt);
		HBox hb3 = new HBox(num1,num2,num3,addbt);
		HBox hb4 = new HBox(clearbt,num0,divbt,eqbt);
		
		

		hb1.setSpacing(2);
		hb2.setSpacing(2);
		hb3.setSpacing(2);
		hb4.setSpacing(2);
		
		//event
		clearbt.setOnAction(e->{
			ov.clear();
			tf.clear();
		});
		
		
		num1.setOnAction(e->{
			String num = tf.getText();
			tf.setText(num + 1);
		});
		num2.setOnAction(e->{
			String num = tf.getText();
			tf.setText(num + 2);
		});
		num3.setOnAction(e->{
			String num = tf.getText();
			tf.setText(num + 3);
		});
		num4.setOnAction(e->{
			String num = tf.getText();
			tf.setText(num + 4);
		});
		
		num5.setOnAction(e->{
			String num = tf.getText();
			tf.setText(num + 5);
		});
		
		num6.setOnAction(e->{
			String num = tf.getText();
			tf.setText(num + 6);
		});
		num7.setOnAction(e->{
			String num = tf.getText();
			tf.setText(num + 7);
		});
		num8.setOnAction(e->{
			String num = tf.getText();
			tf.setText(num + 8);
		});
		num9.setOnAction(e->{
			String num = tf.getText();
			tf.setText(num + 9);
		});
		num0.setOnAction(e->{
			String num = tf.getText();
			tf.setText(num + 0);
		});
		
		
		addbt.setOnAction(e->{
			try {
			ov.clear();
			String number1 = tf.getText();
			ov.add(number1);
			ov.add("+");
			tf.clear();
			}catch(Exception e2) {
				System.out.println(e2);
			}

		});
		subbt.setOnAction(e->{
			try {
				ov.clear();
				String number1 = tf.getText();
				ov.add(number1);
				ov.add("-");
				tf.clear();
				}catch(Exception e2) {
					System.out.println(e2);
				}

		});
		mulbt.setOnAction(e->{
			try {
				ov.clear();
				String number1 = tf.getText();
				ov.add(number1);
				ov.add("x");
				tf.clear();
				}catch(Exception e2) {
					System.out.println(e2);
				}

		});
		divbt.setOnAction(e->{
			try {
				ov.clear();
				String number1 = tf.getText();
				ov.add(number1);
				ov.add("/");
				tf.clear();
				}catch(Exception e2) {
					System.out.println(e2);
				}

		});
		
		eqbt.setOnAction(e->{
			String num = tf.getText().trim();
			ov.add(num);
			int number1 = Integer.parseInt(ov.get(0).trim());
			int number2 = Integer.parseInt(num);
			
			if(ov.get(1) == "+") {
				int result;
				result = number1 + number2;
				String resultTx = Integer.toString(result);
				ov.add(resultTx);
				tf.setText(resultTx);
			}else if(ov.get(1) == "x") {
				int result;
				result = number1 * number2;
				String resultTx = Integer.toString(result);
				ov.add(resultTx);
				tf.setText(resultTx);
			}else if(ov.get(1) == "-") {
				int result;
				result = number1 - number2;
				String resultTx = Integer.toString(result);
				ov.add(resultTx);
				tf.setText(resultTx);
				
			}else if(ov.get(1) == "/") {
				float result;
				result = (float)(number1) / (float)(number2);
				String resultTx = Float.toString(result);
				ov.add(resultTx);
				tf.setText(resultTx);
			}else {
				
			}
		});
		
		
		VBox vb = new VBox(lv,tf,hb1,hb2,hb3,hb4);
		vb.setSpacing(2);
		vb.setPadding(new Insets(2));
		
		Scene scene = new Scene(vb,200,200);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Calculator");
	}

	public static void main(String[] args) {
		launch(args);
	}

}






