
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
		
		Button bt = new Button("Ŭ��");
		Button bt2 = new Button("Ŭ��");
		
		bt.setOnAction(e->{
			lb.setText("�ȳ��ϼ���");
		});
		
		bt2.setOnAction(e->{
			String a = lb.getText();
			System.out.println("�� �ؽ�Ʈ : " + a);
		});
		
		VBox vb = new VBox(lb,bt,bt2);
		
	
		
		Scene scene = new Scene(vb,500,500);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("��");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
