
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Note extends Application {

	@Override
	public void start(Stage primaryStage) {

		
		String filePath = "hungry/hungry.txt";
		
		//파일 읽고 쓰기
		
		//파일 쓰기
		/*
		
		String filePath = "hungry/hungry.txt";
		String content = "Good sing Good music";
//		
//				
//				
//		try {
//			Files.write(Paths.get(filePath),content.getBytes());
//		} catch (Exception e) {
//			System.out.println("내용저장 에러남");
//		}
		try {
		String loadText = new String(Files.readAllBytes(Paths.get(filePath)));
			System.out.println(loadText);
		}catch(Exception e) {
			System.out.println("파일 내용가져오는데 에러발생");
		}
		*/
		
		//ui
		
		
		
		TextArea ta = new TextArea();
		Button savebt = new Button("Save");
		Button loadbt = new Button("Load");
		
		savebt.setOnAction(e->{
			
			String content = ta.getText();
			
			saveContent(filePath, content);
		});
		loadbt.setOnAction(e->{
			String content = loadContent(filePath);
			
			ta.setText(content);
		});
		
		
		
		HBox hb = new HBox(savebt,loadbt);
		hb.setSpacing(2);
		VBox vb = new VBox(ta,hb);
		vb.setSpacing(2);
		vb.setPadding(new Insets(2));
	
		Scene scene = new Scene(vb,300,300);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("note");
	
	
	}
	
	
	public void saveContent(String filePath, String content) {
		try {
		Files.write(Paths.get(filePath),content.getBytes());
		}catch(Exception e) {
			System.out.println("파일 저장 에러");
		}
		
	}
	
	
	public String loadContent (String filePath) {
		
		String  content = "";
		try {
			content = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			System.out.println("파일 가져오기 에러");
		}
		
		return content;
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
